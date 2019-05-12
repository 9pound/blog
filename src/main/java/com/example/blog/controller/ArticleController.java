package com.example.blog.controller;



import com.example.blog.commons.BlogResult;
import com.example.blog.entity.*;
import com.example.blog.reporsitory.CategoryRepository;
import com.example.blog.reporsitory.EsBlogRepository;
import com.example.blog.reporsitory.SortRepository;
import com.example.blog.service.ArticleService;
import com.example.blog.service.CommentService;
import com.example.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private SortRepository sortRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CommentService commentServiceImpl;
    @Autowired
    private EsBlogRepository esBlogRepository;

    @RequestMapping("/editor")
    public ModelAndView ifLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        //系统分类字典
        List<Sort> sortList =  sortRepository.findAll();
        //个人分类字典
        List<Category> categoryList = categoryRepository.findCategoriesByUserId(user.getUserId());
        modelAndView.addObject("sort",sortList);
        modelAndView.addObject("category",categoryList);
        modelAndView.setViewName("editor2");
        return modelAndView;

    }
    @RequestMapping("/post")
    @ResponseBody
    public BlogResult saveArticle(Article article, HttpServletRequest request){
        HttpSession  session = request.getSession();
        User user = (User)session.getAttribute("user");
        article.setUserId(user.getUserId());
        Article newArticle = articleServiceImpl.newArticle(article);
        System.out.println(newArticle.getId());
        BlogResult result = new BlogResult();
        if(newArticle != null){
            esBlogRepository.save(new EsBlog(newArticle));
            result.setMessage("文章保存成功");
            result.setStatus(200);
        }
        return result;
    }
    //阅读某篇文章
    @RequestMapping(value="/get")
    public ModelAndView getArticle(@RequestParam("id")String id,
                                   @RequestParam("userId")Integer userId
                                   ){
        Article article = articleServiceImpl.getCurrentArticle(id);
        //阅读量加1；
        article.setArticleRead(article.getArticleRead()+1);
        articleServiceImpl.updateOrSaveArticle(article);

        //获得作者最新的几片文章
        User user = userServiceImpl.findByUserId(userId);
        List<Article> newest = articleServiceImpl.getNewestArticle(userId);
        //获得文章所有评论
        List<Comment> comments = commentServiceImpl.getAllCommentByArticleId(article.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.addObject("article",article);
        modelAndView.addObject("newest",newest);
        modelAndView.addObject("last",newest.get(0).getArticleTime());
        modelAndView.addObject("comments",comments);
        modelAndView.setViewName("single");

        return  modelAndView;
    }
    @RequestMapping("/delete")
    public void deleteArticleById(@RequestParam("id")String id){
        articleServiceImpl.deleteArticleById(id);
    }

    @RequestMapping("/popular")
    public ModelAndView popular(){
        List<Article> article = articleServiceImpl.findAllOrderByArticleRead();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article",article);
        modelAndView.setViewName("popular_result");
        return modelAndView;
    }
    @RequestMapping("/newest")
    public ModelAndView  newest(Model model){
        List<Article> article = articleServiceImpl.findAllOrOrderByArticleTime();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article",article);
        modelAndView.setViewName("newest_result");
        return modelAndView;
    }



}
