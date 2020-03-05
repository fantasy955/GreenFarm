package edu.cn.green_farm.mapper;

import edu.cn.green_farm.entity.CartItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartItemMapper {
    /**
     * 添加一个商品到购物车
     *
     * @param cartItem 添加商品的信息
     * @return 受影响的行数
     */
    public Integer add(CartItem cartItem);

    /**
     * 通过id查找cart里的商品信息
     *
     * @param id 购物车的商品id
     * @return 购物车商品信息
     */
    public CartItem findById(Integer id);


    /**
     * 通过uid、pid查找cart里的商品信息
     *
     * @param uid 用户id
     * @param pid 农产品id
     * @return 购物车商品信息
     */
    public CartItem findByUidAndPid(Integer uid, Integer pid);

    /**
     * 通过用户id查找该用户的购物车
     *
     * @param uid 用户id
     * @return 用户的购物车所有信息
     */
    public List<CartItem> findByUid(Integer uid);

    /**
     * 更新CartItem
     *
     * @param cartItem 待更新的对象
     * @return 受影响的行数
     */
    public Integer update(CartItem cartItem);

    /**
     * 通过id删除购物车中的信息
     *
     * @param id cartItem Id
     * @return 受影响的行数
     */
    public Integer deleteById(Integer id);
}
