package com.example.blog.reporsitory;
import com.example.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;




public interface ArticlePagingMongoDBRepository extends Repository<Article,String> {
    Page<Article> findAllByUserId(Integer userId, Pageable pageable);
}
