package com.tx.mall.service.impl;

import com.tx.mall.MallApplicationTests;
import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.enums.RoleEnum;
import com.tx.mall.pojo.User;
import com.tx.mall.service.IUserService;
import com.tx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class UserServiceImplTest extends MallApplicationTests {
    @Autowired
    private IUserService userService;
    public static final String USERNAME = "jack2";

    public static final String PASSWORD = "123456";

    @Before
    public void register() {

            User user = new User(USERNAME, PASSWORD, "jack2@qq.com", RoleEnum.CUSTOMER.getCode());
            userService.register(user);

    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}