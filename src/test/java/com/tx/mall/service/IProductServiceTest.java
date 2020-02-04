package com.tx.mall.service;

import com.tx.mall.MallApplicationTests;
import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.vo.ProductVo;
import com.tx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IProductServiceTest extends MallApplicationTests {
    @Autowired
    private  IProductService productService;

    @Test
    public void list() {
        ResponseVo<List<ProductVo>> responseVo = productService.list(null, 1, 1);

        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}