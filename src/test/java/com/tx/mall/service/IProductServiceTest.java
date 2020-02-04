package com.tx.mall.service;

import com.github.pagehelper.PageInfo;
import com.tx.mall.MallApplicationTests;
import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class IProductServiceTest extends MallApplicationTests {
    @Autowired
    private  IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 1, 1);

        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}