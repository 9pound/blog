package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleServiceImpl;

    @RequestMapping(value = "/")
    public ModelAndView loadArticle(){
       List<Article> list = articleServiceImpl.loadArticle();
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("index");
       modelAndView.addObject("article",list);
       return  modelAndView;
    }

}
