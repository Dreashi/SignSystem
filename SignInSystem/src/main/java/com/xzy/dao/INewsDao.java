package com.xzy.dao;

import com.xzy.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INewsDao {

   public int saveNews(List<News> newsList);

   public News loadNews(int newsId);

   public int updateNewsSupport(int newsId);

   public int updateNewsDissupport(int newsId);

   public int deleteAllOldNews();

   public List<News> loadAllNewsOrderTime(int currentPage);

   public List<News> loadAllNewsOrderHeat(int currentPage);

   public List<News> loadAllNewsByMark(@Param("newsMark") String newsMark, @Param("currentPage") int currentPage);

   public int loadNewsNumber();

   public int loadNewsNumberByMark(String newsMark);
}
