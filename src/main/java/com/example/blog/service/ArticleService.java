package com.example.blog.service;

import com.example.blog.entity.Article;

import java.util.List;

public interface ArticleService {
      Article newArticle(Article article);
      List<Article> loadArticle();
      Article getCurrentArticle(String Id);
      List<Article> getNewestArticle(Integer userId);
      Article updateOrSaveArticle(Article article);

}
