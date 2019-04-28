package com.example.blog.commons;

public class BlogResult {
    private String message;
    private Integer status;
    private String Id;

    public BlogResult() {
    }

    public BlogResult(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
