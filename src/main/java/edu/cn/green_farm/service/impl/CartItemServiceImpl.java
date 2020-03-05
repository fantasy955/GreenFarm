package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.CartItem;
import edu.cn.green_farm.mapper.CartItemMapper;
import edu.cn.green_farm.service.ICartItemService;
import edu.cn.green_farm.service.exception.InsertException;
import edu.cn.green_farm.service.exception.UpdateException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {
    @Resource
    private CartItemMapper cartItemMapper;

    @Override
    public Integer add(CartItem cartItem) {
        if (cartItem.getUid() == null) {
            throw new InsertException("请先进行登录！");
        }
        if (cartItem.getPid() == null || cartItem.getPrice() == null || cartItem.getCount() == null) {
            throw new InsertException("未设置待添加商品信息！");
        }
        return cartItemMapper.add(cartItem);
    }

    @Override
    public CartItem findById(Integer id) {
        return cartItemMapper.findById(id);
    }

    @Override
    public CartItem findByUidAndPid(Integer uid, Integer pid) {
        return cartItemMapper.findByUidAndPid(uid, pid);
    }

    @Override
    public List<CartItem> findByUid(Integer uid) {
        return cartItemMapper.findByUid(uid);
    }

    @Override
    public Integer update(CartItem cartItem) {
        CartItem data = cartItemMapper.findById(cartItem.getId());
        if (data == null) {
            throw new UpdateException("购物车更新失败！之前的购物车没有该商品！");
        }
        return cartItemMapper.update(cartItem);
    }

    @Override
    public Integer deleteById(Integer id) {
        return cartItemMapper.deleteById(id);
    }
}
