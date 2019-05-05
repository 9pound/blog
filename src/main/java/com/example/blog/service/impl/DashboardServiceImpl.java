package com.example.blog.service.impl;

import com.example.blog.reporsitory.ArticlePagingMongoDBRepository;
import com.example.blog.reporsitory.CategoryRepository;
import com.example.blog.reporsitory.UserRepository;
import com.example.blog.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private ArticlePagingMongoDBRepository articlePagingMongoDBRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


}
