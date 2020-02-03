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
import java.util.Comparator;
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

        //查询子目录

        categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());


        findSubCategory(categoryVoList,categories);


      return   ResponseVo.success(categoryVoList);
    }
    private void findSubCategory(List<CategoryVo> categoryVoList,List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for(Category category : categories){
                //如果查到内容，要设置子目录，还要继续往下查
                if(categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = category2CategoryVo(category);

                    subCategoryVoList.add(subCategoryVo);
                }
            }
            subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
            categoryVo.setSubCategories(subCategoryVoList);
            //多级目录及递归
            findSubCategory(subCategoryVoList,categories);

        }

    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }


}
