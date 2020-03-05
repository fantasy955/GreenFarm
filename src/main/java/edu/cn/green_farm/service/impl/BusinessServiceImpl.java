package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.Business;
import edu.cn.green_farm.mapper.BusinessMapper;
import edu.cn.green_farm.service.IBusinessService;
import edu.cn.green_farm.service.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class BusinessServiceImpl implements IBusinessService {
    @Resource
    private BusinessMapper businessMapper;

    @Override
    public Business reg(Business business) throws InsertException, DuplicateKeyException {
        // 根据商家名查询商家数据
        Business data = findByBusinessname(business.getBusinessname());
        System.err.println("data=" + data);
        // 判断数据是否为null
        if (data == null) {
            if (business.getBusinessname() == null) {
                throw new InsertException("注册失败!请填写商家名");
            }
            if (business.getPassword() == null) {
                throw new InsertException("注册失败!请填写密码!");
            }
            // 是：允许注册
            // 补充需要添加的字段
            // 设置是否删除字段为否
            business.setIsDelete(0);
            Date now = new Date();
            business.setCreatedTime(now);
            business.setCreatedUser(business.getBusinessname());
            business.setModifiedTime(now);
            business.setModifiedUser(business.getBusinessname());
            // 【处理密码加密】
            // 1. 根据UUID生成盐值，这里的盐值统一大写
            String salt = UUID.randomUUID().toString().toUpperCase();
            // 2. 获取前端界面输入的密码作为原始密码
            String srcPassword = business.getPassword();
            // 3. 用MD5对密码进行加密,获得新密码
            String md5Password = getMd5Password(srcPassword, salt);
            // 4. 将加密后的密码存放到数据库中
            business.setPassword(md5Password);
            // 5. 将盐值存放到数据库中
            business.setSalt(salt);
            // 执行注册
            addnew(business);
            return business;
        } else {
            throw new DuplicateKeyException("注册商家失败!您注册的商家名" + business.getBusinessname() + "已存在!");
        }
    }

    @Override
    public Business login(String businessname, String password) throws BusinessNotFoundException, PasswordNotMatchException {
        // 根据商户名查询商户数据
        Business data = findByBusinessname(businessname);
        // 判断商户是否为null
        if (data == null) {
            // 是: 抛出异常商户名不存在
            throw new BusinessNotFoundException("登录失败!您尝试登录的商户名" + businessname + "不存在!");
        }
        // 否：
        // 判断商户数据是否被删除
        if (data.getIsDelete() == 1) {
            // 是：抛出异常，商户名不存在
            throw new BusinessNotFoundException("登录失败!您尝试登录的商户名" + businessname + "已经被注销!");
        }
        // 否
        // 取出数据库中的密码和盐值
        // 对输入的密码进行MD5加密，与数据库中的密码进行比较
        String md5Password = getMd5Password(password, data.getSalt());
        // 比对成功，将查询到的商户数据中的密码和盐值设置为null，不返回给商户
        if (md5Password.equals(data.getPassword())) {
            // 匹配成功，将密码和盐值设为null
            data.setPassword(null);
            data.setSalt(null);
            // 返回商户数据
            return data;
        } else {
            // 比对失败，抛出异常，密码不匹配
            throw new PasswordNotMatchException("登录失败!您尝试登录的商户密码错误!");
        }
    }

    @Override
    public void changePassword(Integer bid, String oldPassword, String newPassword) throws BusinessNotFoundException, PasswordNotMatchException, UpdateException {
        // 根据商户id查询商户数据
        Business data = findById(bid);
        // 判断商户数据是否为null
        if (data == null) {
            // 是：抛出异常，BusinessNotFoundException
            throw new BusinessNotFoundException("修改密码失败!您尝试修改的商户数据不存在!");
        }
        // 判断商户数据是否被删除
        if (data.getIsDelete() == 1) {
            // 是：抛出异常，BusinessNotFoundException
            throw new BusinessNotFoundException("修改密码失败!您尝试修改的商户数据已被注销!");
        }
        // 取出盐值，用于后面的判断
        String salt = data.getSalt();
        // 对输入的原始密码进行加密，再与数据库中的进行匹配
        String md5Password = getMd5Password(oldPassword, salt);
        // 判断密码是否与数据库中匹配
        if (md5Password.equals(data.getPassword())) {
            // 对新的密码进行加密
            String newMd5Password = getMd5Password(newPassword, salt);
            // 是：执行修改操作
            updatePassword(bid, newMd5Password, data.getBusinessname(), new Date());
        } else {
            // 否：抛出异常，PasswordNotMatchException
            throw new PasswordNotMatchException("修改密码失败！您输入的密码与原始密码不匹配！");
        }
    }

    @Override
    public Business getById(Integer bid) {
        Business data = findById(bid);
        data.setPassword(null);
        data.setSalt(null);
        data.setIsDelete(null);
        return data;
    }

    @Override
    public void changeInfo(Business business) throws BusinessNotFoundException, UpdateException {
        // 根据id查询商户数据
        Business data = findById(business.getId());
        // 判断数据是否为null
        if (data == null) {
            throw new UserNotFoundException("修改个人资料失败！您尝试访问的商户数据不存在!");
        }
        // 判断数据是否删除
        if (data.getIsDelete() == 1) {
            throw new UserNotFoundException("修改个人资料失败！您尝试访问的商户数据已注销!");
        }
        // 添加两项日志
        business.setModifiedUser(business.getBusinessname());
        business.setModifiedTime(new Date());
        // 执行更新
        updateInfo(business);
    }

    @Override
    public void changeAvatar(Integer bid, String avatar) throws BusinessNotFoundException, UpdateException {
        // 根据用户id查询用户数据
        Business data = findById(bid);
        // 判断用户数据是否为null
        if (data == null) {
            throw new UserNotFoundException("上传头像失败！您尝试访问的用户数据不存在!");
        }
        if (data.getIsDelete() == 1) {
            throw new UserNotFoundException("上传头像失败！您尝试访问的用户数据已被注销!");
        }
        // 执行修改
        updateAvatar(bid, avatar, data.getBusinessname(), new Date());
    }

    /**
     * 对原始密码和盐值执行MD5加密
     *
     * @param srcPassword 原始密码
     * @param salt        盐值
     * @return 加密后的密码
     */
    private String getMd5Password(String srcPassword, String salt) {
        String src = salt + srcPassword + salt;
        for (int i = 0; i < 10; i++) {
            src = DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();
        }
        return src;
    }


    /**
     * 插入商家数据
     *
     * @param business 商家数据
     */
    private void addnew(Business business) {
        Integer rows = businessMapper.addnew(business);
        if (rows != 1) {
            throw new InsertException("新增商家数据时出现未知错误!");
        }
    }

    /**
     * 通过商家名查询商家数据
     *
     * @param businessname 商家名
     * @return 匹配的商家数据，如果没有匹配的数据，则返回null
     */
    private Business findByBusinessname(String businessname) {
        return businessMapper.findByBusinessname(businessname);
    }

    /**
     * 修改商家密码
     *
     * @param bid          商家id
     * @param password     商家密码
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     */
    private void updatePassword(Integer bid, String password, String modifiedUser, Date modifiedTime) {
        Integer rows = businessMapper.updatePassword(bid, password, modifiedUser, modifiedTime);
        if (rows != 1) {
            throw new UpdateException("修改密码时发生未知错误!修改密码失败!");
        }
    }

    /**
     * 根据商家id查询修改密码需要的商家数据
     *
     * @param bid 商家id
     * @return 匹配的商家数据，如果不匹配返回null
     */
    private Business findById(Integer bid) {
        return businessMapper.findById(bid);
    }

    /**
     * 修改商家信息
     *
     * @param business 商家信息
     * @return 受影响的行数
     */
    private void updateInfo(Business business) {
        Integer rows = businessMapper.updateInfo(business);
        if (rows != 1) {
            throw new UpdateException("修改商家信息时发生未知错误!");
        }
    }

    /**
     * 上传头像
     *
     * @param bid          商家id
     * @param avatar       商家头像
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改执行时间
     * @return 受影响的行数
     */
    private void updateAvatar(Integer bid, String avatar, String modifiedUser, Date modifiedTime) {
        Integer rows = businessMapper.updateAvatar(bid, avatar, modifiedUser, modifiedTime);
        if (rows != 1) {
            throw new UpdateException("上传头像失败!上传头像时出现未知错误!");
        }
    }
}
