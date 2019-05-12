package com.example.blog.reporsitory;

import com.example.blog.entity.Comment;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CommentMongodbRepository extends Repository<Comment,Integer> {
    List<Comment> getAllByArticleId(String Id);
    Comment save(Comment comment);
}
