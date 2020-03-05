package edu.cn.green_farm.service;

import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.service.exception.*;

import java.util.List;

public interface IFarmProductService {
    /**
     * 农产品持久层
     *
     * @param farmProduct 待保存对象
     * @return 受影响的行数
     */
    public Integer add(FarmProduct farmProduct) throws InsertException;

    /**
     * 根据农产品id查找
     *
     * @param id 农产品id
     * @return 查找到了农产品对象
     */
    public FarmProduct findById(Integer id);

    /**
     * 根据bid查找农产品
     *
     * @param bid 商户id
     * @return 该商户上架的的所有农产品
     */
    public List<FarmProduct> findByBid(Integer bid);

    /**
     * 模糊查询
     *
     * @param titleKey 产品名称key
     * @return 名称包含该关键字的农产品list
     */
    public List<FarmProduct> findByTitleKey(String titleKey, Integer pageIndex, Integer pageSize) throws PageParamErrorException;

    /**
     * 获取包含titleKey关键字农产品页数
     *
     * @param pageSize 页面大小
     * @return 页面数
     */
    public Integer findByTitleKeyPageCount(String titleKey, Integer pageSize) throws PageParamErrorException;

    /**
     * 分页查询正在出售的农产品
     *
     * @param pageIndex 页号
     * @param pageSize  页大小
     * @return 在该页的农产品
     */
    public List<FarmProduct> findOnSellByPage(Integer pageIndex, Integer pageSize) throws PageParamErrorException;

    /**
     * 获取正在出售的农产品的页数
     *
     * @param pageSize 页面大小
     * @return 页面数
     */
    public Integer findOnSellPageCount(Integer pageSize) throws PageParamErrorException;

    public Integer getProductsPageCountByPageSizeAndBid(Integer bid, Integer pageSize) throws PageParamErrorException;

    public Integer getProductsCountByBid(Integer bid) throws PageParamErrorException;

    public List<FarmProduct> getProductsByPageAndSizeAndBid(Integer bid, Integer pageSize, Integer currentPage) throws PageParamErrorException;

//    /**
//     * 分页查询正在出售的农产品
//     * @param pageIndex 页号
//     * @param pageSize 页大小
//     * @return 在该页的农产品
//     */
//    public List<FarmProduct> fuzzyFindByPage(String fuzzySql, Integer pageIndex, Integer pageSize) throws PageParamErrorException;
//
//    /**
//     * 获取正在出售的农产品的页数
//     * @param pageSize 页面大小
//     * @return 页面数
//     */
//    public Integer fuzzyFindPageCount(String fuzzySql, Integer pageSize) throws PageParamErrorException;

    /**
     * 获取最新的农产品信息（数量）
     *
     * @param size 需要获取的数量
     * @return 农产品list
     */
    public List<FarmProduct> findLastedFarmProduct(Integer size) throws PageParamErrorException;

    /**
     * 获取最热的农产品信息（数量）
     *
     * @param size 需要获取的数量
     * @return 农产品list
     */
    public List<FarmProduct> findHotFarmProduct(Integer size) throws PageParamErrorException;

    /**
     * 更新农产品
     *
     * @param farmProduct 待更新的农产品对象
     */
    public Integer update(FarmProduct farmProduct) throws UpdateException;

    /**
     * 通过id删除农产品
     *
     * @param id 农产品id
     * @return 受影响的行数
     */
    public Integer deleteById(Integer id, Integer bid) throws DeleteException;

    /**
     * 通过id下架农产品
     *
     * @param id 农产品id
     * @return 受影响的行数
     */
    public Integer unshelveById(Integer id, Integer bid) throws DeleteException;

    FarmProduct findByIdAndBid(Integer id, Integer bid) throws UpdateException, UserNotFoundException;

    Integer onhelveByIdAndBid(Integer id, Integer bid);


}
