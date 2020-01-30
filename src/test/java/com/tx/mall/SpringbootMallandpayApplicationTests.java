package com.tx.mall;

import com.tx.mall.dao.CategoryMapper;
import com.tx.mall.pojo.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMallandpayApplicationTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void contextLoads() {

        Category category = categoryMapper.findById(100006);
        System.out.println(category.toString());
    }

}
