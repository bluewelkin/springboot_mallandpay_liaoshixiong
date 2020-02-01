package com.tx.mall.controller;


import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.form.UserLoginForm;
import com.tx.mall.form.UserRegisterForm;
import com.tx.mall.pojo.User;
import com.tx.mall.service.IUserService;
import com.tx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.tx.mall.consts.MallConst.CURRENT_USER;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {




    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseVo registet(@RequestBody UserRegisterForm userRegisterForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("注册提交的信息有误，{} {}",bindingResult.getFieldError().getField(),bindingResult.getFieldError().getDefaultMessage());

        }
     //   log.info("username={}",user.getUsername());

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);

        return userService.register(user);


      //  return ResponseVo.success();

    }

    @PostMapping("/login")
    public ResponseVo<User> login(@RequestBody UserLoginForm userLoginForm, BindingResult bindingResult,
                                  HttpSession session) {

        if(bindingResult.hasErrors()) {
            return ResponseVo.error(ResponseEnum.PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(),userLoginForm.getPassword());

// 设置Session
        session.setAttribute(CURRENT_USER,userResponseVo.getData());

        return userResponseVo;

    }






    }
