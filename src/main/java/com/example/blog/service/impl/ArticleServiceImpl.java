package com.example.blog.service.impl;

import com.example.blog.entity.Article;
import com.example.blog.entity.User;
import com.example.blog.reporsitory.ArticleMongoDBRepository;
import com.example.blog.reporsitory.ArticlePagingMongoDBRepository;
import com.example.blog.reporsitory.UserRepository;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMongoDBRepository articleMongoDBRepository;

    @Autowired
    private ArticlePagingMongoDBRepository articlePagingMongoDBRepository;

    @Autowired
    private UserRepository userRepository;

    public Article newArticle(Article article) {
        return articleMongoDBRepository.save(article);
    }

    public List<Article> loadArticle() {
        //查询所有的文章
        List<Article> list = articleMongoDBRepository.findAll();

        for (Article article : list) {
           User user = userRepository.findByUserId(article.getUserId());
            System.out.println(article.getId());
           //查找用户名
            article.setUserName(user.getUserName());
            //添加文章概要
            String  outline = article.getArticleContent().length()<50?article.getArticleContent():article.getArticleContent().substring(0,50);
            article.setOutline(outline);

        }
        return list;
    }
    public Article getCurrentArticle(String Id){
        return articleMongoDBRepository.getById(Id);
    }
    public List<Article> getNewestArticle(Integer userId){
        return articleMongoDBRepository.findTop5ByUserIdOrderByArticleTimeDesc(userId);
    }
    public Article updateOrSaveArticle(Article article){
        return  articleMongoDBRepository.save(article);
    }
    public Page<Article> pagingArticle(Integer userId, PageRequest pageRequest){
        return articlePagingMongoDBRepository.findAllByUserId(userId,pageRequest);
    }
    public void deleteArticleById(String id){
        articleMongoDBRepository.deleteById(id);
    }
    public List<Article> findAll(){
        return articleMongoDBRepository.findAll();
    }

    public List<Article> findAllOrderByArticleRead(){

        Sort sort = Sort.by(Sort.Direction.DESC,"articleRead");

        return articleMongoDBRepository.findAll(sort);

    }
    public List<Article> findAllOrOrderByArticleTime(){
        Sort sort = Sort.by(Sort.Direction.DESC,"articleTime");
        return articleMongoDBRepository.findAll(sort);
    }
}