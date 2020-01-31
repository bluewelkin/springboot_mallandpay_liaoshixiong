package com.tx.mall.service.impl;

import com.tx.mall.MallApplicationTests;
import com.tx.mall.enums.RoleEnum;
import com.tx.mall.pojo.User;
import com.tx.mall.service.IUserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class UserServiceImplTest extends MallApplicationTests {
    @Autowired
    private IUserService userService;
    public static final String USERNAME = "jack2";

    public static final String PASSWORD = "123456";

    @Test
    public void register() {

            User user = new User(USERNAME, PASSWORD, "jack2@qq.com", RoleEnum.CUSTOMER.getCode());
            userService.register(user);

    }
}