package com.xzy.service.util;


import com.xzy.dao.INewsDao;
import com.xzy.service.IReptileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@Service
public class NFDFlightDataTimerTask  {
    @Autowired
    private IReptileService reptileService;
    @Autowired
    private INewsDao newsDao;

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int [] markNumber =new int[4];


    public int[] getMarkNumber(){
        return markNumber;
    }
    @Scheduled(cron = "0 0 4 * * *")
    public void initNumber() {
        System.out.println(formatter.format(Calendar.getInstance().getTime()));
        newsDao.deleteAllOldNews();//先删除数据库的新闻
        List list=reptileService.initNewsList();//爬去当天的新闻
        newsDao.saveNews(list);//存入数据库
        markNumber[0]=newsDao.loadNewsNumber();
        markNumber[1]=newsDao.loadNewsNumberByMark("科技");
        markNumber[1]=newsDao.loadNewsNumberByMark("文化");
        markNumber[1]=newsDao.loadNewsNumberByMark("娱乐");
    }
}
