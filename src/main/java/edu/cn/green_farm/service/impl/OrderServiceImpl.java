package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.Order;
import edu.cn.green_farm.entity.OrderItem;
import edu.cn.green_farm.mapper.OrderMapper;
import edu.cn.green_farm.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Integer addOrder(Order order) {
        Integer rows1 = orderMapper.addOrder(order);
        Integer rows2 = orderMapper.addOrderItems(order.getOrderItems());
        return rows2;
    }

    @Override
    public List<Order> findOrdersByUid(Integer uid) {
        List<Order> orders = orderMapper.findOrdersByUid(uid);
        for (int i = 0; i < orders.size(); ++i) {
            List<OrderItem> orderItems = orderMapper.findOrderItemsByOno(orders.get(i).getOno());
            orders.get(i).setOrderItems(orderItems);
        }
        return orders;
    }
}
