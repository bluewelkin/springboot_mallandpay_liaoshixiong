package com.tx.mall.service.impl;

import com.tx.mall.dao.CategoryMapper;
import com.tx.mall.pojo.Category;
import com.tx.mall.service.ICategoryService;
import com.tx.mall.vo.CategoryVo;
import com.tx.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.tx.mall.consts.MallConst.ROOT_PARENT_ID;

@Service
public class CategoryServiceImpl  implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<Category> categories = categoryMapper.selectAll();
       // 查出parentid=0的数据

        for(Category category:categories){
            if (category.getParentId().equals(ROOT_PARENT_ID)) {
                CategoryVo categoryVo =new CategoryVo();
                BeanUtils.copyProperties(category,categoryVo);
                categoryVoList.add(categoryVo);

            }

        }
//		for (Category category : categories) {
//			if (category.getParentId().equals(ROOT_PARENT_ID)) {
//				CategoryVo categoryVo = new CategoryVo();
//				BeanUtils.copyProperties(category, categoryVo);
//				categoryVoList.add(categoryVo);
//			}
//		}
      return   ResponseVo.success(categoryVoList);
    }
}
