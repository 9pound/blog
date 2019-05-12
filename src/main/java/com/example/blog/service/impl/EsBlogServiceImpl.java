package com.example.blog.service.impl;

import com.example.blog.entity.EsBlog;
import com.example.blog.reporsitory.EsBlogRepository;
import com.example.blog.service.EsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EsBlogServiceImpl implements EsBlogService {
    @Autowired
    private EsBlogRepository esBlogRepository;
    public Page<EsBlog> searchSimilar(String title, String content, Pageable pageable){
        return esBlogRepository.findDistinctEsBlogByArticleTitleContainingOrArticleContentContaining(title,content,pageable);
    }
    public EsBlog index(EsBlog entity){
        return  esBlogRepository.index(entity);
    }
}
