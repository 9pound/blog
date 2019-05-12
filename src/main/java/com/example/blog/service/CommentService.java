package com.example.blog.service;

import com.example.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByArticleId(String id);
    Comment save(Comment comment);
}
