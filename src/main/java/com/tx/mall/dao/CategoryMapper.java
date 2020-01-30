package com.tx.mall.dao;

import com.tx.mall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from mall_category where id = #{id}")
    Category findById(@Param("id") Integer id);

}