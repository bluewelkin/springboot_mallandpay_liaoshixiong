package com.tx.mall.service;

import com.tx.mall.vo.ProductVo;
import com.tx.mall.vo.ResponseVo;

import java.util.List;

public interface IProductService {
    ResponseVo<List<ProductVo>> list(Integer categoryId,Integer pageNum,Integer pageSize);
}
