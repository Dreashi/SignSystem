package com.xzy.model;

import java.io.Serializable;

public class News implements Serializable{
    private int newsId;
    private String newsDateTime;
    private int newsWatchNums;
    private String newsMark;
    private String newsHref;
    private String newsFileName;
    private  String newsKeyWord;
    private int newsSupports;
    private int newsDissupports;
    private int newsOperate;



    public String getNewsHref() {
        return newsHref;
    }

    public String getNewsMark() {
        return newsMark;
    }

    public void setNewsMark(String newsMark) {
        this.newsMark = newsMark;
    }

    public void setNewsHref(String newsHref) {
        this.newsHref = newsHref;
    }

    private String newsKeyImg;

    public String getNewsKeyWord() {
        return newsKeyWord;
    }

    public void setNewsKeyWord(String newsKeyWord) {
        this.newsKeyWord = newsKeyWord;
    }

    public String getNewsKeyImg() {
        return newsKeyImg;
    }

    public void setNewsKeyImg(String newsKeyImg) {
        this.newsKeyImg = newsKeyImg;
    }



    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsDateTime() {
        return newsDateTime;
    }

    public void setNewsDateTime(String newsDateTime) {
        this.newsDateTime = newsDateTime;
    }

    public int getNewsWatchNums() {
        return newsWatchNums;
    }

    public void setNewsWatchNums(int newsWatchNums) {
        this.newsWatchNums = newsWatchNums;
    }

    public String getNewsFileName() {
        return newsFileName;
    }

    public void setNewsFileName(String newsFileName) {
        this.newsFileName = newsFileName;
    }

    public int getNewsSupports() {
        return newsSupports;
    }

    public void setNewsSupports(int newsSupports) {
        this.newsSupports = newsSupports;
    }

    public int getNewsDissupports() {
        return newsDissupports;
    }

    public void setNewsDissupports(int newsDissupports) {
        this.newsDissupports = newsDissupports;
    }

    public int getNewsOperate() {
        return newsOperate;
    }

    public void setNewsOperate(int newsOperate) {
        this.newsOperate = newsOperate;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsDateTime='" + newsDateTime + '\'' +
                ", newsWatchNums=" + newsWatchNums +
                ", newsMark='" + newsMark + '\'' +
                ", newsHref='" + newsHref + '\'' +
                ", newsFileName='" + newsFileName + '\'' +
                ", newsKeyWord='" + newsKeyWord + '\'' +
                ", newsSupports=" + newsSupports +
                ", newsDissupports=" + newsDissupports +
                ", newsOperate=" + newsOperate +
                ", newsKeyImg='" + newsKeyImg + '\'' +
                '}';
    }
}
