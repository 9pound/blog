package com.example.blog.commons;

import java.util.List;

public class Paging<T> {
    List<T> list;
    //总页数
    Integer totalPages;
    //记录条数
    Integer totalElements;
    //当前页
    Integer currentPage;
    //每页显示条数
    Integer size;

    public Paging() {
    }

    public Paging(List<T> list, Integer totalPages, Integer totalElements, Integer currentPage) {
        this.list = list;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
