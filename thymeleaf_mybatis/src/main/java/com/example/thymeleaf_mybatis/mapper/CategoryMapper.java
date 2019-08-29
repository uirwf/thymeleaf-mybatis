package com.example.thymeleaf_mybatis.mapper;

import com.example.thymeleaf_mybatis.domain.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 种类mapper
 */
@Mapper
public interface CategoryMapper {

    @Insert("insert into category_ (name) values (#{name})")
    public void save(Category c);

    @Delete("delete from category_ where id = #{id}")
    public void delete(Integer id);

    @Update("update category_ set name = #{name} where id = #{id}")
    public void update(Category c);

    @Select("select * from category_")
    public List<Category> findAll();

    @Select("select * from category_ where id = #{id}")
    public Category get(Integer id);

}
