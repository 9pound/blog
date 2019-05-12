package com.example.blog.reporsitory;

import com.example.blog.entity.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    Page<EsBlog> findDistinctEsBlogByArticleTitleContainingOrArticleContentContaining(String title, String content, Pageable pageable);

}
