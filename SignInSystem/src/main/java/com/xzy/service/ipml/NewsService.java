package com.xzy.service.ipml;

import com.xzy.dao.INewsDao;
import com.xzy.model.News;
import com.xzy.service.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsService implements INewsService {
    @Resource
    private INewsDao newsDao;

    @Override
    public boolean saveNews(List<News> list) {
        int count =newsDao.saveNews(list);
        return count>0?true:false;
    }


    public News loadNews(int newsId) {
         News news =newsDao.loadNews(newsId);
        return  news;
    }

    @Override
    public boolean updateNewsSupport(int newsId) {
        int count = newsDao.updateNewsSupport(newsId);
        return count>0?true:false;
    }


    @Override
    public boolean updateNewsDissupport(int newsId) {
        int count = newsDao.updateNewsDissupport(newsId);
        return count>0?true:false;
    }

    @Override
    public boolean deleteAllOldNews() {
        int count = newsDao.deleteAllOldNews();
        return count>0?true:false;
    }


    @Override
    public List<News> loadAllNewsOrderTime(int currentPage) {
        List list =newsDao.loadAllNewsOrderTime(currentPage);
        int count=list.size();
        return  count>0?list:null;


    }

    @Override
    public List<News> loadAllNewsOrderHeat(int currentPage) {
        List list =newsDao.loadAllNewsOrderHeat(currentPage);
        int count=list.size();
        return  count>0?list:null;
    }

    @Override
    public List<News> loadAllNewsByMark(String newsMark,int currentPage) {
        List list =  newsDao.loadAllNewsByMark(newsMark,currentPage);
        int count=list.size();
        return  count>0?list:null;
    }

    @Override
    public int loadNewsNumber() {
        return  newsDao.loadNewsNumber();
    }

    @Override
    public int loadNewsNumberByMark(String newsMark) { return newsDao.loadNewsNumberByMark(newsMark); }


}
