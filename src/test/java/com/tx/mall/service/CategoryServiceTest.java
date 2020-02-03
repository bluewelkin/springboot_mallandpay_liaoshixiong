package com.tx.mall.service;

import com.tx.mall.MallApplicationTests;
import com.tx.mall.enums.ResponseEnum;
import com.tx.mall.vo.CategoryVo;
import com.tx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;


    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();

        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }
}