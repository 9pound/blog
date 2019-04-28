package com.example.blog.reporsitory;

import com.example.blog.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleMongoDBRepository extends CrudRepository<Article,String> {
    Article getById(String Id);
    List<Article> findAll();
    List<Article> findTop5ByUserIdOrderByArticleTimeDesc(Integer userId);

}
