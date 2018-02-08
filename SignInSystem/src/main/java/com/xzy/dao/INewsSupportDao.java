package com.xzy.dao;


import com.xzy.model.NewsSupport;

import java.util.List;

public interface INewsSupportDao {
    public NewsSupport loadByUserIdAndNewsId(NewsSupport newsSupport);
    public int saveNewsSupport(NewsSupport newsSupport);
    public int saveNewsDissupport(NewsSupport newsSupport);
    public List<NewsSupport> loadByUserId(int userId);
}
