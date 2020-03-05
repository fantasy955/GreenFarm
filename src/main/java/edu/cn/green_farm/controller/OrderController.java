package edu.cn.green_farm.controller;


import edu.cn.green_farm.entity.Address;
import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.entity.Order;
import edu.cn.green_farm.entity.OrderItem;
import edu.cn.green_farm.service.IAddressService;
import edu.cn.green_farm.service.IFarmProductService;
import edu.cn.green_farm.service.IOrderService;
import edu.cn.green_farm.util.ResponseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IFarmProductService farmProductService;

    @PostMapping("/create")
    public ResponseResult<Object> addOrder(String data, Integer addressId, HttpSession session) {
        Integer uid;
        try {
            uid = getUidFromSession(session);
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        JSONObject json = JSONObject.fromObject(data);
        JSONArray jsonArray = json.getJSONArray("goods");

        //获取收货地址
        Address address = addressService.getById(addressId);

        Order order = new Order();
        order.setUid(uid);

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        Date date = new Date();
        String ono = String.format("%4d%02d%02d%7d", year, month, day, (new Random().nextInt(9000000) + 1000000));
        order.setOno(Long.parseLong(ono));
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvDistrict(address.getDistrict());
        order.setRecvAddress(address.getAddress());
        order.setOrderTime(date);
        order.setStatus(0);
        order.setCreatedTime(new Date());
        order.setCreatedUser((String) session.getAttribute("username"));
        Double totalPrice = 0.0;
        for (int i = 0; i < jsonArray.size(); ++i) {
            FarmProduct farmProduct = farmProductService.findById((Integer) jsonArray.getJSONObject(i).get("pid"));
            OrderItem orderItem = new OrderItem();
            orderItem.setOno(order.getOno());
            orderItem.setGoodsId(farmProduct.getId());
            orderItem.setGoodsCount((Integer) jsonArray.getJSONObject(i).get("count"));
            orderItem.setGoodsPrice(farmProduct.getPrice());
            totalPrice += orderItem.getGoodsCount() * orderItem.getGoodsPrice();
            order.getOrderItems().add(orderItem);
        }
        order.setPay(totalPrice);
        orderService.addOrder(order);
        return new ResponseResult<Object>(SUCCESS, ono);
    }

    @PostMapping("/getOrder")
    public ResponseResult<List<Order>> findOrderByUid(HttpSession session) {
        Integer uid;
        try {
            uid = getUidFromSession(session);
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        List<Order> orderList = orderService.findOrdersByUid(uid);
        return new ResponseResult<List<Order>>(SUCCESS, orderList);
    }
}
