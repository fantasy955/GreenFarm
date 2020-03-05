package edu.cn.green_farm.mapper;


import edu.cn.green_farm.entity.FarmProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmProductMapperTestCase {
    @Resource
    private FarmProductMapper farmProductMapper;

    @Test
    public void add() {
        Date now = new Date();
        FarmProduct farmProduct = new FarmProduct();
        farmProduct.setBid(1);
        farmProduct.setItemType(0);
        farmProduct.setTitle("TEST_TEST");
        farmProduct.setSellPoint("TEST_TEST");
        farmProduct.setPrice(20.20);
        farmProduct.setNum(20);
        farmProduct.setImage("123123");
        farmProduct.setStatus(1);
        farmProduct.setPriority(20);
        farmProduct.setCreatedTime(now);
        farmProduct.setCreatedUser("TEST_TEST");
        farmProduct.setModifiedTime(now);
        farmProduct.setModifiedUser("TEST_TEST");
        Integer rows = farmProductMapper.add(farmProduct);
        System.err.println("rows = " + rows);
    }

    @Test
    public void findById() {
        FarmProduct farmProduct = farmProductMapper.findById(10000028);
        System.err.println(farmProduct);
    }

    @Test
    public void findByBid() {
        List<FarmProduct> farmProducts = farmProductMapper.findByBid(2);
        for (FarmProduct farmProduct : farmProducts) {
            System.err.println(farmProduct);
        }
    }

//    @Test
//    public void findByTitleKey(){
//        List<FarmProduct> farmProducts = farmProductMapper.findByTitleKey("有机");
//        for (FarmProduct farmProduct : farmProducts) {
//            System.err.println(farmProduct);
//        }
//    }

    @Test
    public void findOnSell() {
        List<FarmProduct> farmProducts = farmProductMapper.findOnSell(0, 4);
        for (FarmProduct farmProduct : farmProducts) {
            System.err.println(farmProduct);
        }
    }

    @Test
    public void findOnSellFarmProductCount() {
        System.err.println(farmProductMapper.findOnSellFarmProductCount());
    }

    @Test
    public void update() {
        FarmProduct farmProduct = farmProductMapper.findById(10000030);
        farmProduct.setTitle("TEST_修改！");
        Integer rows = farmProductMapper.update(farmProduct);
        System.err.println(rows);
    }

//    @Test
//    public void deleteById(){
//        Integer rows = farmProductMapper.deleteById(10000030);
//        System.err.println(rows);
//    }
}
