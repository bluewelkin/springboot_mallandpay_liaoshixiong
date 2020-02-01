package com.tx.mall.service;

import com.tx.mall.pojo.User;
import com.tx.mall.vo.ResponseVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserService {
    /**
     * 注册
     *
     * @param use
     * @return
     */

    ResponseVo register(User use);

    /**
     * 登录
     */

    ResponseVo<User> login(String username, String password);

}