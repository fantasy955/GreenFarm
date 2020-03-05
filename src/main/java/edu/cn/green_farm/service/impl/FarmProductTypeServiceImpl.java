package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.FarmProductType;
import edu.cn.green_farm.mapper.FarmProductTypeMapper;
import edu.cn.green_farm.service.IFarmProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FarmProductTypeServiceImpl implements IFarmProductTypeService {
    @Resource
    FarmProductTypeMapper farmProductTypeMapper;

    @Override
    public List<FarmProductType> getTypeList() {
        return farmProductTypeMapper.getTypeList();
    }
}
