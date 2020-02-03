package com.tx.mall.service;

import com.tx.mall.vo.CategoryVo;
import com.tx.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * 商品目录
 */
public interface ICategoryService {

	ResponseVo<List<CategoryVo>> selectAll();

	void findSubCategoryId(Integer id, Set<Integer> resultSet);


}
