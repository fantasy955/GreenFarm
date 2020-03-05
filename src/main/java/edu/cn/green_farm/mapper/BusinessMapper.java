package edu.cn.green_farm.mapper;


import edu.cn.green_farm.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 商家持久层接口
 *
 * @author wjl
 */
@Mapper
public interface BusinessMapper {

    /**
     * 插入商家数据
     *
     * @param business 商家数据
     * @return 受影响的行数
     */
    Integer addnew(Business business);

    /**
     * 通过商家名查询商家数据
     *
     * @param username 商家名
     * @return 匹配的商家数据，如果没有匹配的数据，则返回null
     */
    Business findByBusinessname(String username);

    /**
     * 修改商家密码
     *
     * @param bid              商家id
     * @param password         商家密码
     * @param modifiedBusiness 修改执行人
     * @param modifiedTime     修改时间
     * @return 受影响的行数
     */
    Integer updatePassword(
            @Param("bid") Integer bid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedBusiness,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据商家id查询修改密码需要的商家数据
     *
     * @param bid 商家id
     * @return 匹配的商家数据，如果不匹配返回null
     */
    Business findById(Integer bid);

    /**
     * 修改商家信息
     *
     * @param user 商家信息
     * @return 受影响的行数
     */
    Integer updateInfo(Business user);

    /**
     * 上传头像
     *
     * @param bid          商家id
     * @param avatar       商家头像
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改执行时间
     * @return 受影响的行数
     */
    Integer updateAvatar(
            @Param("bid") Integer bid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);


}
