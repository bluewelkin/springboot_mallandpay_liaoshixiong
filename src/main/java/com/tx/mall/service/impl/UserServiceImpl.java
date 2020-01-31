package com.tx.mall.service.impl;

import com.tx.mall.dao.UserMapper;
import com.tx.mall.enums.RoleEnum;
import com.tx.mall.pojo.User;
import com.tx.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 注册
     * @param user
     */
    @Override
    public void register(User user) {

//        目的:用户名，密码，邮箱写入数据库
//        用户名，邮箱email不能重复

        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
           throw new RuntimeException("username不能重复");
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            throw new RuntimeException("邮箱email不能重复");
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());
        //MD5摘要算法(Spring自带)
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
        ));

        int i = userMapper.insertSelective(user);


    }
}