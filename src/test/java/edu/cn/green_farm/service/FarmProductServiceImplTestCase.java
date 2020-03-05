package edu.cn.green_farm.service;

import edu.cn.green_farm.entity.FarmProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmProductServiceImplTestCase {
    @Autowired
    private IFarmProductService farmProductService;

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
        Integer rows = farmProductService.add(farmProduct);
        System.err.println("rows = " + rows);
    }

    @Test
    public void findById() {
        FarmProduct farmProduct = farmProductService.findById(10000031);
        System.err.println(farmProduct);
    }

    @Test
    public void findByBid() {
        List<FarmProduct> farmProducts = farmProductService.findByBid(2);
        for (FarmProduct farmProduct : farmProducts) {
            System.err.println(farmProduct);
        }
    }

//    @Test
//    public void findByTitleKey(){
//        List<FarmProduct> farmProducts = farmProductService.findByTitleKey("有机");
//        for (FarmProduct farmProduct : farmProducts) {
//            System.err.println(farmProduct);
//        }
//    }

    @Test
    public void findOnSellByPage() {
        List<FarmProduct> farmProducts = farmProductService.findOnSellByPage(1, 5);
        for (FarmProduct farmProduct : farmProducts) {
            System.err.println(farmProduct);
        }
    }

    @Test
    public void update() {
        FarmProduct farmProduct = farmProductService.findById(10000031);
        farmProduct.setTitle("TEST_修改！");
        Integer rows = farmProductService.update(farmProduct);
        System.err.println(rows);
    }

//    @Test
//    public void deleteById(){
//        Integer rows = farmProductService.deleteById(10000031);
//        System.err.println(rows);
//    }
}
