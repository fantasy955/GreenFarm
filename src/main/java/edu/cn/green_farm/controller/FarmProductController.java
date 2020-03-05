package edu.cn.green_farm.controller;

import edu.cn.green_farm.controller.exception.*;
import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.service.IFarmProductService;
import edu.cn.green_farm.util.ResponseResult;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/farm_product")
public class FarmProductController extends BaseController {
    private final static String LOCAL_PATH_PRODUCTIMAGES = "\\images\\portal\\";
    private final static String STATIC_PATH_FOR_PRODUCT_IAMGES = "\\src\\main\\resources\\static";
    private final static int PRODUCT_STATUS_WAITTRINGFORCHECK = 3;//待审核
    private final static int PRODUCT_STATUS_ONOFFER = 1;//在售
    private final static int PRODUCT_STATUS_AUDITFAILURE = 2;//审核未通过
    private static final int STATUS_OUT = 0;//下架
    private final static int PRODUCT_STATUS_MOVINGIMAGES_ERROR = 5;//图片格式化过程出错
    private final static int PRODUCT_STATUS_DELETE_BY_BUSINESS = -1; //商户删除 删除后商户不可在产品列表查看到该产品
    /**
     * 上传文件的大小
     */
    public static final long FILE_MAX_SIZE = 50 * 1024 * 1024;

    /**
     * 允许上传的文件类型
     */
    public static final List<String> FILE_CONTENT_TYPES = new ArrayList<>();

    static {
        FILE_CONTENT_TYPES.add("image/jpeg");
        FILE_CONTENT_TYPES.add("image/png");
    }

    @Autowired
    private IFarmProductService farmProductService;

    @PostMapping("/add")
    public ResponseResult<Void> add(FarmProduct farmProduct, HttpSession session) {
//        System.err.println(farmProduct);
        farmProduct.setBid(getBidFromSession(session));
        farmProduct.setModifiedUser(session.getAttribute("businessname").toString());
        farmProduct.setCreatedUser(session.getAttribute("businessname").toString());
        farmProduct.setCreatedTime(new Timestamp(new Date().getTime()));
        farmProduct.setModifiedTime(new Timestamp(new Date().getTime()));
        farmProduct.setStatus(PRODUCT_STATUS_WAITTRINGFORCHECK);


        Object o = session.getAttribute("imageDir");
        if (o == null) {
            throw new RequestException("添加产品失败!");
        } else {
            farmProduct.setImage(o.toString().replace('\\', '/'));
            farmProductService.add(farmProduct);
            Runnable runnable_moveImages = new Runnable() {
                @Override
                public void run() {
                    File file = new File(getProductImageParentPath() + o.toString());
                    File files[] = file.listFiles();
                    int i = 1;
                    for (File f : files) {
                        String absolutePath = f.getAbsolutePath();
                        String fileName = f.getName().split("\\.")[0];
                        String parent = f.getParent();
                        fileName = String.valueOf(i);
                        String suffixName = absolutePath.substring(absolutePath.lastIndexOf("."));
                        suffixName = "_big.png";
                        String smallIamgeFileName = fileName + ".jpg";
                        fileName = fileName + suffixName;
                        File fileNew = new File(parent, fileName);
                        File smallFile = new File(parent, smallIamgeFileName);
                        try {
                            //静态资源
                            //大图
                            Files.copy(f.toPath(), new File(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString(), fileName).toPath());
                            //小图
                            Files.copy(f.toPath(), new File(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString(), smallIamgeFileName).toPath());
                            //格式化图片大小
                            Thumbnails.of(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString() + fileName).size(430, 360).keepAspectRatio(false).toFile(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString() + fileName);
                            Thumbnails.of(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString() + smallIamgeFileName).size(84, 84).keepAspectRatio(false).toFile(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString() + smallIamgeFileName);

                            if (i == 1) {
                                File collectImage = new File(f.getParent(), "collect.png");
                                Files.copy(f.toPath(), collectImage.toPath());
                                Thumbnails.of(collectImage.getAbsolutePath()).size(230, 180).keepAspectRatio(false).toFile(collectImage.getAbsolutePath());
//                                System.err.println(collectImage.getAbsolutePath());
                                Files.copy(f.toPath(), new File(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString(), "collect.png").toPath());
                                Thumbnails.of(collectImage.getAbsolutePath()).size(230, 180).keepAspectRatio(false).toFile(new File(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES + o.toString(), "collect.png").getAbsoluteFile());

                            }
                            //动态资源
                            //小图
                            Files.copy(f.toPath(), smallFile.toPath());
                            Thumbnails.of(smallFile.getAbsolutePath()).size(84, 84).keepAspectRatio(false).toFile(smallFile.getAbsolutePath());
                            //大图
                            f.renameTo(fileNew);
                            Thumbnails.of(fileNew.getAbsolutePath()).size(430, 360).keepAspectRatio(false).toFile(fileNew.getAbsolutePath());

                        } catch (IOException e) {
                            e.printStackTrace();
                            farmProduct.setStatus(PRODUCT_STATUS_MOVINGIMAGES_ERROR);
                            farmProductService.update(farmProduct);
                            throw new FileUploadException("添加产品失败!");
                        }
                        i++;
                    }
                }
            };
            Thread thread_moveImages = new Thread(runnable_moveImages);
            thread_moveImages.start();
        }
        System.err.println(farmProduct);
        return new ResponseResult<>(SUCCESS);
    }

//    @PostMapping("/findById/{id}")
//    public ResponseResult<FarmProduct> findById(@PathVariable("id")Integer id, HttpSession session) {
//        FarmProduct farmProduct = farmProductService.findById(id);
//        return new ResponseResult<FarmProduct>(SUCCESS, farmProduct);
//    }

    @PostMapping("/findById/{id}")
    public ResponseResult<FarmProduct> findById(@PathVariable("id") Integer id, HttpSession session) {
        Integer bid = getBidFromSession(session);
        FarmProduct farmProduct = farmProductService.findByIdAndBid(id, bid);
        if (farmProduct == null)
            throw new RequestException("获取农产品信息失败");
        return new ResponseResult<FarmProduct>(SUCCESS, farmProduct);
    }

    @PostMapping("findByBid/{bid}")
    public ResponseResult<List<FarmProduct>> findByBid(@PathVariable("bid") Integer bid, HttpSession session) {
        List<FarmProduct> farmProductList = farmProductService.findByBid(bid);
        return new ResponseResult<List<FarmProduct>>(SUCCESS, farmProductList);
    }

    @PostMapping("findByTitleKey")
    public ResponseResult<List<FarmProduct>> findByTitleKey(String titleKey, Integer pageIndex, Integer pageSize, HttpSession session) {
        List<FarmProduct> farmProductList = farmProductService.findByTitleKey(titleKey, pageIndex, pageSize);
        Integer pageCount = farmProductService.findByTitleKeyPageCount(titleKey, pageSize);
        //按页查询时，顺带把总页数页塞回去
        return new ResponseResult<List<FarmProduct>>(pageCount, SUCCESS, farmProductList);
    }

    @PostMapping("findOnSellByPage")
    public ResponseResult<List<FarmProduct>> findOnSellByPage(Integer pageIndex, Integer pageSize, HttpSession session) {
        List<FarmProduct> farmProductList = farmProductService.findOnSellByPage(pageIndex, pageSize);
        Integer pageCount = farmProductService.findOnSellPageCount(pageSize);
        //按页查询时，顺带把总页数页塞回去
        return new ResponseResult<List<FarmProduct>>(pageCount, SUCCESS, farmProductList);
    }

//    @PostMapping("/deleteById/{id}")
//    public ResponseResult<Void> deleteById(@PathVariable("id")Integer id, HttpSession session) {
//        farmProductService.deleteById(id);
//        return new ResponseResult<Void>(SUCCESS);
//    }

    /*
        产品图片上传
     */
    @PostMapping("/upload.do")
    public ResponseResult<String> handleUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
        String dir = getProductImageParentPath() + session.getAttribute("imageDir").toString();
//        System.err.println(dir);
        // 【1】检查操作
        // 检查是否存在上传文件
        if (file.isEmpty()) {
            // 上传完文件为空，抛出异常：FileEmptyException
            throw new FileEmptyException("没有选择上传的文件，或选中的文件为空！上传失败!");
        }
        // 检查文件大小
        if (file.getSize() > FILE_MAX_SIZE) {
            // 上传文件大小超出限制抛出异常：FileSizeOutOfLimitException
            throw new FileSizeOutOfLimitException("上传文件大小超出限制!上传文件失败!");
        }
        // 检查文件类型
        if (!FILE_CONTENT_TYPES.contains(file.getContentType())) {
            // 不包含->上传文件失败,抛出异常：FileTypeNotSupportException
            throw new FileTypeNotSupportException("上传文件的类型不允许!上传文件失败!");
        }

        // 【3】给上传文件重新起名字
        // 1. 将从客户端获取的文件名
        String originalFilename = file.getOriginalFilename();
        // 后缀-截取
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 因为系统ms值，可能会重复，所以加上一个随机数（）这里拼接字符串的时候要放在中间
        String fileName = System.currentTimeMillis() + "" + (new Random().nextInt(90000000) + 10000000) + suffix;

        File dest = new File(dir, fileName);

        // 执行保存操作
        try {
            file.transferTo(dest);
//            System.err.println("上传完成!");
        } catch (IOException e) {
//             这种抛出异常的方法叫做：异常的再次封装
            // 这种IOException不适合统一异常处理，必须catch然后在处理
            // 抛出异常：上传失败
            throw new FileUploadException("上传失败!");
        }
        // 返回
        ResponseResult<String> rr = new ResponseResult<>();
        rr.setState(SUCCESS);
        return rr;
    }

    @PostMapping("/mkdir")
    public ResponseResult<String> handleMkdir(HttpSession session) {
        String localImageDir = generateImageDir();
        File file = new File(getProductImageParentPath(), localImageDir);
        while (file.exists()) {
            localImageDir = generateImageDir();
            file = new File(getProductImageParentPath(), localImageDir);
        }
        file.mkdirs();
        File file1 = new File(new File("").getAbsolutePath() + STATIC_PATH_FOR_PRODUCT_IAMGES, localImageDir);
        file1.mkdirs();
        session.setAttribute("imageDir", localImageDir);
        System.err.println("mkdir:" + localImageDir);
        return new ResponseResult<>(SUCCESS);
    }


    @PostMapping("findLasted/{size}")
    public ResponseResult<List<FarmProduct>> findLastedFarmProduct(@PathVariable("size") Integer size, HttpSession session) {
        List<FarmProduct> farmProductList = farmProductService.findLastedFarmProduct(size);
        return new ResponseResult<List<FarmProduct>>(SUCCESS, farmProductList);
    }

    @PostMapping("findHot/{size}")
    public ResponseResult<List<FarmProduct>> findHotFarmProduct(@PathVariable("size") Integer size, HttpSession session) {
        List<FarmProduct> farmProductList = farmProductService.findHotFarmProduct(size);
        return new ResponseResult<List<FarmProduct>>(SUCCESS, farmProductList);
    }

    @GetMapping("/myproducts")
    public ResponseResult<List<FarmProduct>> handleGetProducts(@RequestParam("page") Integer page, @RequestParam(value = "limit", defaultValue = "10") Integer limit, HttpSession session) {
//        Integer bid = 2;
        Integer bid = getBidFromSession(session);

        List<FarmProduct> farmProducts = farmProductService.getProductsByPageAndSizeAndBid(bid, limit, page);
        ResponseResult farmProductResponseResult = new ResponseResult(SUCCESS, farmProducts);

        farmProductResponseResult.setCount(farmProductService.getProductsCountByBid(bid));
        farmProductResponseResult.setCode(SUCCESSFUL);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (FarmProduct farmProduct : farmProducts) {
            farmProduct.setStrTimeUpdate(simpleDateFormat.format(farmProduct.getModifiedTime()));
        }
        return farmProductResponseResult;
    }

    @PostMapping("/deleteById/{id}")
    public ResponseResult<Void> deleteById(@PathVariable("id") Integer id, HttpSession session) {
        Integer bid = getBidFromSession(session);
        System.err.println(bid + "请求删除" + id);
        farmProductService.deleteById(id, bid);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/unshelveById/{id}")
    public ResponseResult<Void> unshelveById(@PathVariable("id") Integer id, HttpSession session) {
        Integer bid = getBidFromSession(session);
        System.err.println(bid + "请求下架" + id);
        FarmProduct farmProduct = farmProductService.findByIdAndBid(id, bid);
        if (farmProduct.getStatus() != PRODUCT_STATUS_ONOFFER)
            throw new RequestException("只有在售商品能够下架");
        farmProductService.unshelveById(id, bid);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/onshelveById/{id}")
    public ResponseResult<Void> onshelveById(@PathVariable("id") Integer id, HttpSession session) {
        Integer bid = getBidFromSession(session);
        FarmProduct farmProduct = farmProductService.findByIdAndBid(id, bid);
        if (farmProduct.getStatus() != STATUS_OUT)
            throw new RequestException("上架失败 只有处于下架状态的农产品能请求上架！");
        if (farmProduct == null)
            throw new RequestException("上架失败 参数错误！");

        Integer rows = farmProductService.onhelveByIdAndBid(id, bid);
        if (rows == 0)
            throw new RequestException("上架失败 参数错误！");
        return new ResponseResult<Void>(SUCCESS);
    }

    protected String getProductImageParentPath() {
        return new File("").getAbsolutePath() + "\\target\\classes\\static";
    }

    protected String generateImageDir() {
        String uuid = UUID.randomUUID().toString().toLowerCase();
        return LOCAL_PATH_PRODUCTIMAGES + uuid + "\\";
    }
}
