package com.tx.mall.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.mall.dao.ProductMapper;
import com.tx.mall.pojo.Product;
import com.tx.mall.service.ICategoryService;
import com.tx.mall.service.IProductService;
import com.tx.mall.vo.ProductVo;
import com.tx.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();


        if (categoryId !=null){
            categoryService.findSubCategoryId(categoryId,categoryIdSet);
            categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);

        List<ProductVo> productVoList = productMapper.selectByCategoryIdSet(categoryIdSet).stream()
                .map(e -> {
                            ProductVo productVo = new ProductVo();
                            BeanUtils.copyProperties(e, productVo);
                            return productVo;
                        }
                ).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo<>(productVoList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }
}


