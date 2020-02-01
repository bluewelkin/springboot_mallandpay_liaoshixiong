package com.tx.mall.service.impl;

import com.tx.mall.dao.UserMapper;
import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.enums.RoleEnum;
import com.tx.mall.pojo.User;
import com.tx.mall.service.IUserService;
import com.tx.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.tx.mall.enums.ResponseEnum.EMAIL_EXIST;
import static com.tx.mall.enums.ResponseEnum.ERROR;
import static com.tx.mall.enums.ResponseEnum.USERNAME_EXIST;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 注册
     * @param user
     */
    @Override
    public ResponseVo register(User user) {

//        目的:用户名，密码，邮箱写入数据库
//        用户名，邮箱email不能重复

        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
           //throw new RuntimeException("username不能重复");
           return ResponseVo.error(USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
           // throw new RuntimeException("邮箱email不能重复");
            return ResponseVo.error(EMAIL_EXIST);
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());
        //MD5摘要算法(Spring自带)
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
        ));

        int i = userMapper.insertSelective(user);
        if(i ==0) {
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();


    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            //用户不存在（返回：用户名或密码错误 ）
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            //密码错误(返回：用户名或密码错误 )
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return ResponseVo.success(user);
    }

    private void error() {
        throw new RuntimeException("意外错误");
    }
}
