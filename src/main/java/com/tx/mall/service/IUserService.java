package com.tx.mall.service;

import com.tx.mall.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserService {


    void register(User use);


}
