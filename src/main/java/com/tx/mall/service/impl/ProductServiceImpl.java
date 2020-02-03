package com.tx.mall.service.impl;

import com.tx.mall.dao.ProductMapper;
import com.tx.mall.pojo.Product;
import com.tx.mall.service.ICategoryService;
import com.tx.mall.service.IProductService;
import com.tx.mall.vo.ProductVo;
import com.tx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<List<ProductVo>> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();

        categoryService.findSubCategoryId(categoryId,categoryIdSet);
        categoryIdSet.add(categoryId);
        List<Product> products = productMapper.selectByCategoryIdSet(categoryIdSet);
        log.info("product={}",products);
        return null;
    }
}


