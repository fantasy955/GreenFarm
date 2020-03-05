package edu.cn.green_farm.mapper;

import edu.cn.green_farm.entity.Order;
import edu.cn.green_farm.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 添加一个订单到数据库
     *
     * @param order 待添加的订单
     * @return 受影响的行数
     */
    Integer addOrder(Order order);

    /**
     * 添加一个订单item list
     *
     * @param orderItems 订单item list
     * @return 受影响的行数
     */
    Integer addOrderItems(List<OrderItem> orderItems);

    /**
     * 得到用户的所有订单数据
     *
     * @return 匹配的订单数据，如果不匹配返回null
     */
    List<Order> findOrdersByUid(Integer uid);

    /**
     * 通过ono获取对应的OrderItem
     *
     * @param ono order no
     * @return OrderItem list
     */
    List<OrderItem> findOrderItemsByOno(Long ono);
}
