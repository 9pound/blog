package com.example.blog.service;

import com.example.blog.entity.Sort;

import java.util.List;

public interface SortService {
    List<Sort> getAll();
    void delete(Integer sortId);
    Sort save(Sort sort);

}
