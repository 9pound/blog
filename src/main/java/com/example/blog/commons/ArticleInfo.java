package com.example.blog.commons;


import com.example.blog.entity.Category;
import com.example.blog.entity.Sort;

import java.util.List;

public class ArticleInfo {
    //系统分类
    private List<Sort> sortList;
    //个人分类
    private List<Category> categoryList;

    public ArticleInfo(List<Sort> sortList, List<Category> categoryList) {
        this.sortList = sortList;
        this.categoryList = categoryList;
    }

    public List<Sort> getSortList() {
        return sortList;
    }

    public void setSortList(List<Sort> sortList) {
        this.sortList = sortList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
