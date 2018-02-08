package com.xzy.service;

import com.xzy.model.News;

import java.util.List;

public interface INewsService {
    public boolean saveNews(List<News> list);

    public News loadNews(int userId);

    public boolean updateNewsSupport(int newsId);

    public boolean updateNewsDissupport(int newsId);

    public boolean deleteAllOldNews();

    public List<News> loadAllNewsOrderTime(int currentPage);

    public List<News> loadAllNewsOrderHeat(int currentPage);

    public  List<News> loadAllNewsByMark(String newsMark, int currentPage);

    public int loadNewsNumber();

    public int loadNewsNumberByMark(String newsMark);
}
