package com.example.blog.entity;

import java.util.Date;

public class Article {
    private Integer articleId;

    private Date articleTime;

    private String articleTitle;

    private Integer articlePermission;

    private Integer articleRead;

    private Integer articleAgree;

    private Integer articleDisagree;

    private Integer categoryId;

    private Integer sortId;

    private Integer userId;

    private String articleContent;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticlePermission() {
        return articlePermission;
    }

    public void setArticlePermission(Integer articlePermission) {
        this.articlePermission = articlePermission;
    }

    public Integer getArticleRead() {
        return articleRead;
    }

    public void setArticleRead(Integer articleRead) {
        this.articleRead = articleRead;
    }

    public Integer getArticleAgree() {
        return articleAgree;
    }

    public void setArticleAgree(Integer articleAgree) {
        this.articleAgree = articleAgree;
    }

    public Integer getArticleDisagree() {
        return articleDisagree;
    }

    public void setArticleDisagree(Integer articleDisagree) {
        this.articleDisagree = articleDisagree;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}