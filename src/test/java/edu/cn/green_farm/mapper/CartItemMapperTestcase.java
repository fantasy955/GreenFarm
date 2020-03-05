package edu.cn.green_farm.mapper;


import edu.cn.green_farm.entity.CartItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartItemMapperTestcase {
    @Resource
    private CartItemMapper cartItemMapper;

    @Test
    public void add() {
        CartItem cartItem = new CartItem();
        cartItem.setPid(1000000);
        cartItem.setUid(1000000);
        cartItem.setCount(50);
        cartItem.setPrice(20.20);
        cartItem.setCreatedUser("TEST");
        cartItem.setCreatedTime(new Date());
        Integer rows = cartItemMapper.add(cartItem);
        System.err.println(rows);
    }

    @Test
    public void findById() {
        CartItem cartItem = cartItemMapper.findById(24);
        System.err.println(cartItem);
    }

    @Test
    public void findByUid() {
        List<CartItem> cartItems = cartItemMapper.findByUid(1);
        for (CartItem cartItem : cartItems) {
            System.err.println(cartItem);
        }
    }

    @Test
    public void update() {
        CartItem cartItem = new CartItem();
        cartItem.setId(24);
        cartItem.setCount(99999);
        cartItem.setModifiedTime(new Date());
        cartItem.setModifiedUser("MOD TEST");
        System.err.println(cartItemMapper.update(cartItem));
        System.err.println(cartItemMapper.findById(24));
    }

    @Test
    public void deleteById() {
        System.err.println(cartItemMapper.deleteById(24));
    }
}
