package edu.cn.green_farm.mapper;

import edu.cn.green_farm.entity.FarmProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmProductTypeMapper {
    List<FarmProductType> getTypeList();
}
