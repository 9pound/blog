package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;


public interface CategoryService {
    Category addCategory(Category category);
    List<Category> findAllByUserId(Integer userId);
    void deleteCategory(Integer categoryId);
}
