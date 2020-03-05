package edu.cn.green_farm.service;

import edu.cn.green_farm.entity.Order;

import java.util.List;

public interface IOrderService {
    /**
     * 添加一个订单到数据库
     *
     * @param order 待添加的订单
     * @return 受影响的行数
     */
    Integer addOrder(Order order);

    /**
     * 得到用户的所有订单数据
     *
     * @return 匹配的订单数据，如果不匹配返回null
     */
    List<Order> findOrdersByUid(Integer uid);
}
