package com.tx.mall.service;

import com.github.pagehelper.PageInfo;
import com.tx.mall.vo.ResponseVo;

public interface IProductService {
    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);
}
