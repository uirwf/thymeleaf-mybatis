package com.example.thymeleaf_mybatis.controller;

import com.example.thymeleaf_mybatis.domain.Category;
import com.example.thymeleaf_mybatis.mapper.CategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 种类控制器
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询所有种类
     * @param model
     * @param start 起始页
     * @param size 每页显示条数
     * @return
     * @throws Exception
     */
    @RequestMapping("/listCategory")
    public String listCategory(Model model,
                               @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id asc");
        List<Category> categoryList = categoryMapper.findAll();
        PageInfo<Category> page =new PageInfo<>(categoryList);
        model.addAttribute("page",page);
        return "listCategory";
    }

    /**
     * 添加种类
     * @param category 接受封装前端数据
     * @return
     * @throws Exception
     */
    @RequestMapping("/addCategory")
    public String save(Category category) throws Exception{
        categoryMapper.save(category);
        return "redirect:/category/listCategory";
    }

    /**
     * 删除种类
     * @param id 种类id
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteCategory")
    public String delete(Integer id) throws Exception{
        categoryMapper.delete(id);
        return "redirect:/category/listCategory";
    }

    /**
     * 返回修改页面回显数据
     * @param id 要修改的种类id
     * @return
     * @throws Exception
     */
    @RequestMapping("/editCategory")
    public ModelAndView edit(Integer id) throws Exception{
        Category category = categoryMapper.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category",category);
        modelAndView.setViewName("editCategory");
        return modelAndView;
    }

    /**
     * 更新种类
     * @param category 接收封装前端数据
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateCategory")
    public String update(Category category) throws Exception{
        categoryMapper.update(category);
        return "redirect:/category/listCategory";
    }

}
