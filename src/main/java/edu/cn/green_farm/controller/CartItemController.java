package edu.cn.green_farm.controller;

import edu.cn.green_farm.entity.CartItem;
import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.service.ICartItemService;
import edu.cn.green_farm.service.IFarmProductService;
import edu.cn.green_farm.util.ResponseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartItemController extends BaseController {
    @Autowired
    private ICartItemService cartItemService;
    @Autowired
    private IFarmProductService farmProductService;

    @PostMapping("/get_by_pids")
    public ResponseResult<List<CartItem>> findByPids(String data, HttpSession session) {
        Integer uid;
        try {
            //从session中获取uid
            uid = getUidFromSession(session);
        } catch (Exception e) {
            return new ResponseResult<>(500, "订单生成失败！请先登录！");
        }
        JSONObject json = JSONObject.fromObject(data);
        JSONArray jsonArray = json.getJSONArray("goods");
        List<CartItem> cartItems = new ArrayList<CartItem>();
        for (int i = 0; i < jsonArray.size(); ++i) {
            CartItem cartItem = new CartItem();
            cartItem.setUid(uid);
            cartItem.setPid((Integer) jsonArray.getJSONObject(i).get("pid"));
            cartItem.setCount((Integer) jsonArray.getJSONObject(i).get("count"));
            FarmProduct farmProduct = farmProductService.findById(cartItem.getPid());
            if (farmProduct == null) {
                return new ResponseResult<>(500, "订单生成失败！购物车中存在未知商品！");
            } else if (farmProduct.getNum() < cartItem.getCount()) {
                return new ResponseResult<>(500, "订单生成失败！购物车中的" + farmProduct.getTitle() + "商品库存不足，只有" + farmProduct.getNum() + "件！");
            }
            cartItem.setPrice(farmProduct.getPrice());
            cartItem.setTitle(farmProduct.getTitle());
            cartItem.setpImage(farmProduct.getImage());
            cartItems.add(cartItem);
        }
        return new ResponseResult<List<CartItem>>(SUCCESS, cartItems);
    }

    @PostMapping("/addCartItem")
    public ResponseResult<Void> add(CartItem cartItem, HttpSession session) {
        try {
            //从session中获取uid
            cartItem.setUid(getUidFromSession(session));
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        //先根据uid、pid
        CartItem data = cartItemService.findByUidAndPid(cartItem.getUid(), cartItem.getPid());
        if (data != null) {
            data.setCount(data.getCount() + cartItem.getCount());
            return update(data, session);
        }
        cartItem.setCreatedTime(new Date());
        //从session中获取username
        cartItem.setCreatedUser((String) session.getAttribute("username"));
        System.err.println(cartItem);
        cartItemService.add(cartItem);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/findById")
    public ResponseResult<CartItem> findById(Integer id, HttpSession session) {
        CartItem cartItem = cartItemService.findById(id);
        return new ResponseResult<>(SUCCESS, cartItem);
    }

    @PostMapping("/get_list")
    public ResponseResult<List<CartItem>> findByUid(HttpSession session) {
        Integer uid = null;
        try {
            //从session中获取uid
            uid = getUidFromSession(session);
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        return new ResponseResult<List<CartItem>>(SUCCESS, cartItemService.findByUid(uid));
    }

    @PostMapping("/update")
    public ResponseResult<Void> update(CartItem cartItem, HttpSession session) {
        Integer uid = null;
        try {
            //从session中获取uid
            cartItem.setUid(getUidFromSession(session));
            cartItem.setModifiedUser((String) session.getAttribute("username"));
            cartItem.setModifiedTime(new Date());
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        if (cartItem.getCount() < 0) {
            return new ResponseResult<>(500, "购物车的单个商品数量需要大于零！");
        } else if (cartItem.getCount() == 0) {
            return deleteById(cartItem.getId(), session);
        } else {
            System.err.println(cartItem);
            cartItemService.update(cartItem);
            return new ResponseResult<Void>(SUCCESS);
        }
    }

    @PostMapping("/deleteById")
    public ResponseResult<Void> deleteById(Integer id, HttpSession session) {
        Integer uid = null;
        try {
            //从session中获取uid
            uid = getUidFromSession(session);
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        cartItemService.deleteById(id);
        return new ResponseResult<Void>(SUCCESS);
    }
}
