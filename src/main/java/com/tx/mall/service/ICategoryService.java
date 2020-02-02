package com.tx.mall.service;

import com.tx.mall.vo.CategoryVo;
import com.tx.mall.vo.ResponseVo;

import java.util.List;

/**
 * 商品目录
 */
public interface ICategoryService {

	ResponseVo<List<CategoryVo>> selectAll();


}
