package com.example.blog.service;

import com.example.blog.entity.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EsBlogService {
    Page<EsBlog> searchSimilar(String title, String content, Pageable pageable);
    EsBlog index(EsBlog entity);
}
