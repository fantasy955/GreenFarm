package edu.cn.green_farm.service;

import edu.cn.green_farm.entity.Business;
import edu.cn.green_farm.service.exception.*;

/**
 * 商家持久层接口
 *
 * @author wjl
 */
public interface IBusinessService {

    /**
     * 商家注册
     *
     * @param bisiness 商家注册时，添加的信息
     * @return 注册成功后商家的数据
     * @throws InsertException       插入数据时异常
     * @throws DuplicateKeyException 违反unique约束异常
     */
    Business reg(Business bisiness) throws InsertException, DuplicateKeyException;

    /**
     * 商家登录
     *
     * @param username 登录名
     * @param password 登录密码
     * @return 成功登录后商家的数据
     * @throws BusinessNotFoundException 商家名不存在异常
     * @throws PasswordNotMatchException 密码不匹配异常
     */
    Business login(String username, String password) throws BusinessNotFoundException, PasswordNotMatchException;

    /**
     * 修改密码
     *
     * @param bid         商家id
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 受影响的行数
     * @throws BusinessNotFoundException 商家不存在异常
     * @throws PasswordNotMatchException 商家密码不匹配异常
     * @throws UpdateException           商家更新数据异常
     */
    void changePassword(Integer bid, String oldPassword, String newPassword) throws BusinessNotFoundException, PasswordNotMatchException, UpdateException;

    /**
     * 根据商家id查询商家数据，用于显示到页面上
     *
     * @param bid 商家id
     * @return 匹配的商家数据，如果没有匹配的商家数据，则返回null
     */
    Business getById(Integer bid);

    /**
     * 商家修改信息
     *
     * @param user 商家信息
     * @throws BusinessNotFoundException 商家不存在异常
     * @throws UpdateException           更新数据异常
     */
    void changeInfo(Business user) throws BusinessNotFoundException, UpdateException;

    /**
     * 上传头像
     *
     * @param bid    商家id
     * @param avatar 商家头像
     * @throws BusinessNotFoundException 商家名不存在异常
     * @throws UpdateException           更新数据异常
     */
    void changeAvatar(Integer bid, String avatar) throws BusinessNotFoundException, UpdateException;

}
