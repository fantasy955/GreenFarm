package edu.cn.green_farm.mapper;


import edu.cn.green_farm.entity.FarmProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FarmProductMapper {
    /**
     * 农产品持久层
     *
     * @param farmProduct 待保存对象
     * @return 受影响的行数
     */
    public Integer add(FarmProduct farmProduct);

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
    public List<FarmProduct> findByTitleKey(String titleKey, Integer beginIndex, Integer size);

    /**
     * 查找包含TitleKey关键字的农产品个数
     *
     * @return 农产品个数
     */
    public Integer findByTitleKeyProductCount(String titleKey);

    /**
     * 分页查询正在出售的农产品
     *
     * @param beginIndex 起始下标
     * @param size       分页大小
     * @return 查到的list集合
     */
    public List<FarmProduct> findOnSell(Integer beginIndex, Integer size);

    /**
     * 获取正在出售的农产品数
     *
     * @return
     */
    public Integer findOnSellFarmProductCount();

    /**
     * 更新农产品
     *
     * @param farmProduct 待更新的农产品对象
     */
    public Integer update(FarmProduct farmProduct);

    /**
     * 通过农产品id删除
     *
     * @param id  农产品id
     * @param bid 商户产品id
     * @return 受影响的行数
     */
    public Integer deleteById(@Param("id") Integer id, @Param("bid") Integer bid);

    /**
     * 获取最新的农产品信息（数量）
     *
     * @param size 需要获取的数量
     * @return 农产品list
     */
    public List<FarmProduct> findLastedFarmProduct(Integer size);

    /**
     * 获取最热的农产品信息（数量）
     *
     * @param size 需要获取的数量
     * @return 农产品list
     */
    public List<FarmProduct> findHotFarmProduct(Integer size);

    /**
     * 获取商户的农产品页数
     *
     * @param pageSize 每页限制
     * @param bid      商户id
     * @return 页数
     */
    Integer getProductsPageCountByPageSizeAndBid(@Param("bid") Integer bid, @Param("pageSize") Integer pageSize);

    /**
     * 通过农产品id下架
     *
     * @param id  农产品id
     * @param bid 商户产品id
     * @return 受影响的行数
     */
    public Integer unshelveById(@Param("id") Integer id, @Param("bid") Integer bid);

    List<FarmProduct> getProductsByPageAndSizeAndBid(@Param("bid") Integer bid, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    Integer getProductsCountByBid(@Param("bid") Integer bid);

    FarmProduct findByIdAndBid(Integer id, Integer bid);

    Integer onhelveByIdAndBid(Integer id, Integer bid);
}
