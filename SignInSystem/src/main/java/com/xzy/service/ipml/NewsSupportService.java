package com.xzy.service.ipml;

import com.xzy.dao.INewsSupportDao;
import com.xzy.model.NewsSupport;
import com.xzy.service.INewsSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsSupportService implements INewsSupportService {
    @Autowired
    private INewsSupportDao newsSupportDao;

    @Override
    public NewsSupport loadByUserIdAndNewsId(NewsSupport newsSupport) {
        NewsSupport ns = newsSupportDao.loadByUserIdAndNewsId(newsSupport);
        return ns;
    }

    @Override
    public List<NewsSupport> loadByUserId(int userId) {
        List list=newsSupportDao.loadByUserId(userId);
        int count = list.size();
        return count>0?list:null;
    }

    @Override
    public boolean saveNewsSupport(NewsSupport newsSupport) {
        int count = newsSupportDao.saveNewsSupport(newsSupport);
        return count>0?true:false;
    }

    @Override
    public boolean saveNewsDisspport(NewsSupport newsSupport) {
        int count = newsSupportDao.saveNewsSupport(newsSupport);
        return count>0?true:false;
    }
}
