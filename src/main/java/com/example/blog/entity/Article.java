package com.example.blog.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Document(collection =  "article")
public class Article {
    @Id
    private String  id;

    private Date articleTime = new Date();

    private String articleTitle;

    private Integer articlePermission = 1;

    private Integer articleRead = 0;

    private Integer articleAgree = 0;

    private Integer articleDisagree = 0;

    private Integer categoryId;

    private Integer sortId;

    private Integer userId;

    private String articleContent;

    @Transient
    private String userName;

    //概要
    @Transient
    private String outline;

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        this.articleTitle = articleTitle;
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
        this.articleContent = articleContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }
}