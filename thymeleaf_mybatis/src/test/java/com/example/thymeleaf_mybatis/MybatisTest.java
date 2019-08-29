package com.example.thymeleaf_mybatis;

import com.example.thymeleaf_mybatis.domain.Category;
import com.example.thymeleaf_mybatis.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThymeleafMybatisApplication.class)
public class MybatisTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void test1(){
        Category category = categoryMapper.get(1);
        System.out.println(category);
    }

    @Test
    public void test2(){
        List<Category> categories = categoryMapper.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}
