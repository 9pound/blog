package com.example.blog.reporsitory;


import com.example.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findCategoriesByUserId(Integer userId);
}
