package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.mapper.FarmProductMapper;
import edu.cn.green_farm.service.IFarmProductService;
import edu.cn.green_farm.service.exception.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class FarmProductServiceImpl implements IFarmProductService {
    @Resource
    private FarmProductMapper farmProductMapper;

    @Override
    public Integer add(FarmProduct farmProduct) throws InsertException {
        if (farmProduct.getBid() == null) {
            throw new InsertException("农产品添加失败！农产品未设置所属商户！");
        }
        if (farmProduct.getTitle() == null) {
            throw new InsertException("农产品添加失败！农产品未设置名称！");
        }
        if (farmProduct.getStatus() != null && farmProduct.getStatus() > 0) {
            if (farmProduct.getPrice() == null) {
                throw new InsertException("农产品添加失败！上架的农产品必须设置售价！");
            }
            if (farmProduct.getNum() == null) {
                throw new InsertException("农产品添加失败！上架的农产品必须设置库存数量！");
            }
        }
        if (farmProduct.getPrice() != null && farmProduct.getPrice() < 0) {
            throw new InsertException("农产品添加失败！农产品售价不能设置为负数！");
        }
        if (farmProduct.getNum() != null && farmProduct.getNum() < 0) {
            throw new InsertException("农产品添加失败！农产品库存数量不能设置为负数！");
        }
        return farmProductMapper.add(farmProduct);
    }

    @Override
    public FarmProduct findById(Integer id) {
        return farmProductMapper.findById(id);
    }

    @Override
    public List<FarmProduct> findByBid(Integer bid) {
        return farmProductMapper.findByBid(bid);
    }

    @Override
    public List<FarmProduct> findByTitleKey(String titleKey, Integer pageIndex, Integer pageSize) {
        if (pageIndex < 1) {
            throw new PageParamErrorException("查询错误！分页查询页码必须大于0！");
        }
        if (pageSize < 1) {
            throw new PageParamErrorException("查询错误！分页查询页大小必须大于0！");
        }
        return farmProductMapper.findByTitleKey(titleKey, (pageIndex - 1) * pageSize, pageSize);
    }

    @Override
    public Integer findByTitleKeyPageCount(String titleKey, Integer pageSize) throws PageParamErrorException {
        if (pageSize < 1) {
            throw new PageParamErrorException("页面大小错误！分页查询页大小必须大于0！");
        }
        //向上取整
        return (farmProductMapper.findByTitleKeyProductCount(titleKey) + pageSize - 1) / pageSize;
    }

    @Override
    public List<FarmProduct> findOnSellByPage(Integer pageIndex, Integer pageSize) throws PageParamErrorException {
        if (pageIndex < 1) {
            throw new PageParamErrorException("查询错误！分页查询页码必须大于0！");
        }
        if (pageSize < 1) {
            throw new PageParamErrorException("查询错误！分页查询页大小必须大于0！");
        }
        return farmProductMapper.findOnSell((pageIndex - 1) * pageSize, pageSize);
    }

    //查询产品分页总页数
    @Override
    public Integer getProductsPageCountByPageSizeAndBid(Integer bid, Integer pageSize) throws PageParamErrorException {
        if (pageSize < 1) {
            throw new PageParamErrorException("页面大小错误！页面大小不能小于1！");
        }
        //向上取整
        return (farmProductMapper.getProductsPageCountByPageSizeAndBid(bid, pageSize) + pageSize - 1) / pageSize;
    }

    @Override
    public Integer getProductsCountByBid(Integer bid) throws PageParamErrorException {
        return farmProductMapper.getProductsCountByBid(bid);
    }

    //根据页码和每页数量查询产品信息
    @Override
    public List<FarmProduct> getProductsByPageAndSizeAndBid(Integer bid, Integer pageSize, Integer currentPage) throws PageParamErrorException {
        if (pageSize < 1) {
            throw new PageParamErrorException("查询错误！分页查询页大小必须大于0！");
        }
        return farmProductMapper.getProductsByPageAndSizeAndBid(bid, pageSize * (currentPage - 1), pageSize);
    }

    @Override
    public Integer findOnSellPageCount(Integer pageSize) throws PageParamErrorException {
        if (pageSize < 1) {
            throw new PageParamErrorException("页面大小错误！页面大小不能小于1！");
        }
        //向上取整
        return (farmProductMapper.findOnSellFarmProductCount() + pageSize - 1) / pageSize;
    }

    @Override
    public List<FarmProduct> findLastedFarmProduct(Integer size) throws PageParamErrorException {
        if (size < 1) {
            throw new PageParamErrorException("最新农产品信息获取失败！大小必须大于零！");
        }
        return farmProductMapper.findLastedFarmProduct(size);
    }

    @Override
    public List<FarmProduct> findHotFarmProduct(Integer size) throws PageParamErrorException {
        if (size < 1) {
            throw new PageParamErrorException("最热农产品信息获取失败！大小必须大于零！");
        }
        return farmProductMapper.findHotFarmProduct(size);
    }

    @Override
    public Integer update(FarmProduct farmProduct) throws UpdateException {
        if (farmProduct.getBid() == null) {
            throw new UpdateException("农产品更新失败！农产品未设置所属商户！");
        }
        if (farmProduct.getTitle() == null) {
            throw new UpdateException("农产品更新失败！农产品未设置名称！");
        }
        if (farmProduct.getStatus() != null && farmProduct.getStatus() > 0) {
            if (farmProduct.getPrice() == null) {
                throw new UpdateException("农产品更新失败！上架的农产品必须设置售价！");
            }
            if (farmProduct.getNum() == null) {
                throw new UpdateException("农产品更新失败！上架的农产品必须设置库存数量！");
            }
        }
        if (farmProduct.getPrice() != null && farmProduct.getPrice() < 0) {
            throw new UpdateException("农产品更新失败！农产品售价不能设置为负数！");
        }
        if (farmProduct.getNum() != null && farmProduct.getNum() < 0) {
            throw new UpdateException("农产品更新失败！农产品库存数量不能设置为负数！");
        }
        if (farmProduct.getModifiedUser() == null) {
            throw new UpdateException("农产品更新失败！未设置更新商户名！");
        }
        if (farmProduct.getModifiedTime() == null) {
            farmProduct.setModifiedTime(new Date());
        }
        return farmProductMapper.update(farmProduct);
    }

    @Override
    public Integer deleteById(Integer id, Integer bid) throws DeleteException {
        Integer rows = 0;
        try {
            rows = farmProductMapper.deleteById(id, bid);
        } catch (Exception e) {
            throw new DeleteException("未找到该农产品，删除失败！");
        }
        return rows;
    }

    @Override
    public Integer unshelveById(Integer id, Integer bid) throws DeleteException {
        Integer rows = 0;
        try {
            rows = farmProductMapper.unshelveById(id, bid);
        } catch (Exception e) {
            throw new DeleteException("未找到该农产品，删除失败！");
        }
        return rows;
    }

    @Override
    public FarmProduct findByIdAndBid(Integer id, Integer bid) throws UpdateException, UserNotFoundException {
        return farmProductMapper.findByIdAndBid(id, bid);
    }

    @Override
    public Integer onhelveByIdAndBid(Integer id, Integer bid) {
        return farmProductMapper.onhelveByIdAndBid(id, bid);
    }
}
