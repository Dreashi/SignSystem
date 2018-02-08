package com.xzy.model;

import java.io.Serializable;

public class NewsSupport implements Serializable{
    private int userId;
    private int newsId;
    private int newsOperate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getNewsOperate() {
        return newsOperate;
    }

    public void setNewsOperate(int newsOperate) {
        this.newsOperate = newsOperate;
    }

    @Override
    public String toString() {
        return "NewsSupport{" +
                "userId=" + userId +
                ", newsId=" + newsId +
                ", newsOperate=" + newsOperate +
                '}';
    }
}
