package com.tx.mall.service;

import com.tx.mall.MallApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class IProductServiceTest extends MallApplicationTests {
    @Autowired
    private  IProductService productService;

    @Test
    public void list() {
        productService.list(100002,1,1);
    }
}