package com.tx.mall.controller;


import com.tx.mall.pojo.User;
import com.tx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping("/register")
    public ResponseVo registet(@RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的信息有误，{} {}",bindingResult.getFieldError().getField(),bindingResult.getFieldError().getDefaultMessage());

        }
        log.info("username={}",user.getUsername());
        return ResponseVo.success();

    }




}
