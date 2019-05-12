package com.example.blog.controller;

import com.example.blog.entity.Article;
import com.example.blog.entity.Slide;
import com.example.blog.entity.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleServiceImpl;
    @Autowired
    private SlideService slideServiceImpl;

    @RequestMapping(value = "/")
    public ModelAndView loadArticle(){
       List<Article> articles = articleServiceImpl.loadArticle();
       List<Slide> slides = slideServiceImpl.findAllBySlideStatus(0);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("index");
       modelAndView.addObject("slide",slides);
       modelAndView.addObject("article",articles);
       return  modelAndView;
    }

}
