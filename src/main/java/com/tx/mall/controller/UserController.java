package com.tx.mall.controller;


import com.tx.mall.pojo.User;
import com.tx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/register")
    public ResponseVo registet(@RequestBody User user){
        log.info("username={}",user.getUsername());
        return ResponseVo.success("注册成功");

    }




}
