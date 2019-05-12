package com.example.blog.controller;

import com.example.blog.entity.EsBlog;
import com.example.blog.service.EsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/esblog")
public class EsBlogController {
    @Autowired
    private EsBlogService esBlogServiceImpl;
    @RequestMapping("/similar")
    public ModelAndView similar(@RequestParam("str") String str){
        Pageable pageable = PageRequest.of(0, 20);
        Page<EsBlog> esBlogs = esBlogServiceImpl.searchSimilar(str,str,pageable);
        List<EsBlog> articles = esBlogs.getContent();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article",articles);
        modelAndView.setViewName("search_result");
        return modelAndView;
    }
}
