package com.tx.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.imooc.mall.dao")
public class SpringbootMallandpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMallandpayApplication.class, args);
    }

}
