package com.example.blog.controller;

import com.example.blog.commons.BlogResult;
import com.example.blog.entity.Category;
import com.example.blog.entity.User;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryServiceImpl;

    @RequestMapping(value="/post")
    @ResponseBody
    public BlogResult addCategory(@RequestParam("category") String categoryName, HttpSession session){
        User user = (User)session.getAttribute("user");
        Category category = new Category();
        category.setUserId(user.getUserId());
        category.setCategoryName(categoryName);
        Category result = categoryServiceImpl.addCategory(category);
        BlogResult blogResult = new BlogResult();
        if (result.getCategoryId() != null) {
            blogResult.setIdInt(result.getCategoryId());
            blogResult.setMessage("保存成功！！！");
            blogResult.setStatus(200);
        } else {
            blogResult.setMessage("保存失败！！！");
            blogResult.setStatus(500);
        }
        return blogResult;
    }
    @RequestMapping("/delete")
    public void deleteCategory(@RequestParam("categoryId") Integer categoryId){
        categoryServiceImpl.deleteCategory(categoryId);

    }
    @RequestMapping("/update")
    @ResponseBody
    public BlogResult updateCategory(Category category,HttpSession session){
        User user = (User)session.getAttribute("user");
        category.setUserId(user.getUserId());
        Category result = categoryServiceImpl.addCategory(category);
        if(result!=null) {
            return new BlogResult("更新成功", 200);
        } else {
            return  new BlogResult("更新失败",500);
        }
    }
    @RequestMapping("/deleteAll")
    public void deleteAll(@RequestParam("ids") String ids){
        String [] categoryIds = ids.split("-");
        for (int i =1; i<categoryIds.length;i++){
            categoryServiceImpl.deleteCategory(Integer.parseInt(categoryIds[i]));
        }
    }

}
