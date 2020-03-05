package edu.cn.green_farm.controller;


import edu.cn.green_farm.entity.FarmProductType;
import edu.cn.green_farm.service.IFarmProductTypeService;
import edu.cn.green_farm.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/farmproducttypes")
public class FarmProdutTypeController extends BaseController {
    @Autowired
    IFarmProductTypeService farmProductTypeService;

    @PostMapping("/typelist")
    public ResponseResult<List<FarmProductType>> handleFarmProductType() {

        List<FarmProductType> farmProductTypes = farmProductTypeService.getTypeList();
        return new ResponseResult<>(SUCCESS, farmProductTypes);
    }
}
