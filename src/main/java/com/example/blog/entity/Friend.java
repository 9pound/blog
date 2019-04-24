package com.example.blog.entity;

public class Friend {
    private Integer freId;

    private Integer userId;

    private Integer userFriendId;

    public Integer getFreId() {
        return freId;
    }

    public void setFreId(Integer freId) {
        this.freId = freId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserFriendId() {
        return userFriendId;
    }

    public void setUserFriendId(Integer userFriendId) {
        this.userFriendId = userFriendId;
    }
}