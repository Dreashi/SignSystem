package com.xzy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.model.News;
import com.xzy.model.NewsSupport;
import com.xzy.service.INewsService;
import com.xzy.service.INewsSupportService;
import com.xzy.service.util.NFDFlightDataTimerTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class NewsController {

    @Resource
    private INewsService newsService;

//    @Resource
//    private IReptileService reptileService;

    @Resource
    private INewsSupportService newsSupportService;

    @Resource
    private NFDFlightDataTimerTask nfdFlightDataTimerTask;


    private static final String [] MARK = {"热门","科技","文化","娱乐"};//分类标识
    private  int [] MarkNumber ={295,112,59,124};//新闻数及每个类别的数量，每天六点自动初始化

    public void setMarkNumber(int [] mn){//设置数量
        for(int i=0;i<mn.length;++i)
            MarkNumber[i]=mn[i];
    }



    @ResponseBody
    @RequestMapping("/loadAllNewsByMark.do")
    public List<News> loadAllNewsByMark(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<News> newsListMark = null;
        setMarkNumber(nfdFlightDataTimerTask.getMarkNumber());//设置条数
        //String temp = (String) request.getSession().getAttribute("mark");
        String temp = request.getParameter("mark");
        System.out.println("temp:"+temp+"--------------------------");
        String reqMark= temp!=null?temp:"热门";//若前端未给定值，则默认为"热门"
        //String reqMark =request.getParameter("mark");//分类标识
        String  strCurrentPage = request.getParameter("currentPage");
        //System.out.println(strCurrentPage+"---------------------------");
        int marknumber =0;//得到该类别的新闻数
        for(int i=0;i<MARK.length;++i){
            if(MARK[i].equals(reqMark)){
                marknumber=MarkNumber[i];
                break;
            }
        }
        int currentPage = 0;//分页数,若传值失败，则赋默认值
        if(strCurrentPage!=null ) {
            currentPage = Integer.parseInt(strCurrentPage)*10;
            if(currentPage>marknumber)//超过数据库的值，直接返回null
                return null;
        }
        //System.out.println("news"+reqMark);
        if(reqMark.equals("热门")) {
            // System.out.println("重新加载热度排序！");
            newsListMark= newsService.loadAllNewsOrderHeat(currentPage);
        }
        else {
            // System.out.println("news"+reqMark);
            newsListMark = newsService.loadAllNewsByMark(reqMark,currentPage);
        }
        // System.out.println(newsListMark.size());
        return newsListMark;
    }

    @ResponseBody
    @RequestMapping("/loadAllNewsOrderTime.do")
    public List<News> loadAllNewsOrderTime(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //    Calendar now = Calendar.getInstance();//获取当前时间
        //每天数据库都会定时删除昨天的新闻，所以这里先获取
        List<News> newsListTime = null;
        setMarkNumber(nfdFlightDataTimerTask.getMarkNumber());//设置条数
        // NumberMark = newsService.loadNewsNumber();//加载数据库的新闻数
        // if(now.get(Calendar.HOUR_OF_DAY)>TIMEMARK && NumberMark==0){//当前时间大于6点并且数量为0，重新获取
        //System.out.println("爬取最新新闻！");
        //newsService.deleteAllOldNews();//删除数据库的旧新闻
//            List list = reptileService.initNewsList();//得到最新的新闻
//            newsService.saveNews(list);//存入数据库
//            NumberMark =  newsService.loadNewsNumber();//获取当前数据库的总数量
//        }

        String  strCurrentPage = request.getParameter("currentPage");
        //  System.out.println(strCurrentPage+"---------------------------");
        // System.out.println(MarkNumber[0]+"=============================");
        int currentPage = 0;//分页数,若传值失败，则赋默认值
        if(strCurrentPage!=null ) {
            currentPage = Integer.parseInt(strCurrentPage)*10;
            if(currentPage>MarkNumber[0])//超过数据库的值，直接返回null
                return null;
        }
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<NewsSupport> listOperate = newsSupportService.loadByUserId(userId);//操作列表
        newsListTime= newsService.loadAllNewsOrderTime(currentPage);//根据分页获取数据库的新闻
//        for(News news:newsListTime)
//            System.out.println(news);
        for(News news: newsListTime){//添加标识
            for(NewsSupport newsSupport:listOperate){
                if(newsSupport.getNewsId() == news.getNewsId()){
                    news.setNewsOperate(newsSupport.getNewsOperate());
                }else{
                    news.setNewsSupports(0);//没有操作就赋值为0
                }
            }
        }
        return newsListTime;
    }

//    @ResponseBody
//    @RequestMapping("/loadAllNewsOrderHeat.do")
//    public List<News> loadAllNewsOrderHeat(){
//
//        if(newsListHeat==null){
//            System.out.println("重新加载热度排序！");
//            newsListHeat= newsService.loadAllNewsOrderHeat();
//        }
//        return newsListHeat;
//    }

    @RequestMapping("/pushNews.do")
    public String saveNews(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<News> list=null;
        News news = new News();
        String context = request.getParameter("newsContext");
        boolean bool;
        if(context.equals(""))
            bool=false;
        else{
            list.add(news);
            news.setNewsFileName(context);
            bool=newsService.saveNews(list);
        }
        return bool?"index":"error";
    }

    @RequestMapping("/updateSupport.do")
    public void updateSupport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("update");

        int newsId = Integer.parseInt(request.getParameter("newsId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int flag = Integer.parseInt(request.getParameter("flag"));

        ObjectMapper mapper = new ObjectMapper();
        NewsSupport newsSupport = new NewsSupport();
        newsSupport.setUserId(userId);
        newsSupport.setNewsId(newsId);
        NewsSupport check =  newsSupportService.loadByUserIdAndNewsId(newsSupport);
        if(check==null) {
            News news = newsService.loadNews(newsId);
            boolean bool = false;//标识是否修改成功
            int isOperate=0;//标识操作的类别
            if (flag == 1) {
                boolean b=newsService.updateNewsSupport(newsId);
                if(b) {//修改成功
                    bool = true;
                    isOperate=1;
                }
                int support = news.getNewsSupports()+1;
                String str = "+" + support;
                response.getWriter().write(mapper.writeValueAsString(str));
            } else {
                boolean b =newsService.updateNewsDissupport(newsId);
                if (b) {//修改成功
                    bool = true;
                    isOperate=-1;
                }
                int dissupport = news.getNewsDissupports()+1;
                String str = "-" + dissupport;
                response.getWriter().write(mapper.writeValueAsString(str));
            }
            if(bool) {//修改成功
                newsSupport.setNewsOperate(isOperate);
                newsSupportService.saveNewsSupport(newsSupport);//存储该操作
            }
        }
        response.getWriter().close();
    }


}
