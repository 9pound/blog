package com.example.blog.service;

import com.example.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ArticleService {
      Article newArticle(Article article);
      List<Article> loadArticle();
      Article getCurrentArticle(String Id);
      List<Article> getNewestArticle(Integer userId);
      Article updateOrSaveArticle(Article article);
      Page<Article> pagingArticle(Integer userId, PageRequest pageRequest);
      void deleteArticleById(String Id);
      List<Article> findAll();

}
