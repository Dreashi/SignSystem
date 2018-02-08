package com.xzy.service;

import com.xzy.model.NewsSupport;

import java.util.List;

public interface INewsSupportService {
    public NewsSupport loadByUserIdAndNewsId(NewsSupport newsSupport);
    public List<NewsSupport> loadByUserId(int userId);
    public boolean saveNewsSupport(NewsSupport newsSupport);
    public boolean saveNewsDisspport(NewsSupport newsSupport);
}
