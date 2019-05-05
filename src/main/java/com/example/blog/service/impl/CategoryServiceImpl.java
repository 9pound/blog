package com.example.blog.service.impl;

import com.example.blog.entity.Category;
import com.example.blog.reporsitory.CategoryRepository;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category){

        return categoryRepository.save(category) ;
    }
    public List<Category> findAllByUserId(Integer userId){
        return categoryRepository.findCategoriesByUserId(userId);
    }
    public void deleteCategory(Integer categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
