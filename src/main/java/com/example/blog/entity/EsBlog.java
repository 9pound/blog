package com.example.blog.entity;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {
    @Id
    private String  id;

    @Field(type = FieldType.Keyword)
    private Date articleTime;

    @Field(type = FieldType.Keyword)
    private String articleTitle;

    @Field(type = FieldType.Keyword)
    private Integer articlePermission = 1;

    @Field(type = FieldType.Keyword)
    private Integer articleRead = 0;

    @Field(type = FieldType.Keyword)
    private Integer articleAgree = 0;

    @Field(type = FieldType.Keyword)
    private Integer articleDisagree = 0;

    @Field(type = FieldType.Keyword)
    private Integer categoryId;

    @Field(type = FieldType.Keyword)
    private Integer sortId;

    @Field(type = FieldType.Keyword)
    private Integer userId;

    @Field(type = FieldType.Keyword)
    private String articleContent;
    @Field(type = FieldType.Keyword)
    private String outline;
    @Field(type = FieldType.Keyword)
    private String userName;
    protected EsBlog() {
    }
    public EsBlog(Article article){
        this.id = article.getId();
        this.articleTime = article.getArticleTime();
        this.articleTitle = article.getArticleTitle();
        this.articlePermission = article.getArticlePermission();
        this.articleRead = article.getArticleRead();
        this.articleAgree = article.getArticleAgree();
        this.articleDisagree = article.getArticleDisagree();
        this.categoryId = article.getCategoryId();
        this.sortId = article.getSortId();
        this.userId = article.getUserId();
        this.articleContent = article.getArticleContent();
        this.outline = article.getArticleContent().length()>50?article.getArticleContent().substring(0,50):article.getArticleContent();
        this.userName = article.getUserName();
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
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
}
