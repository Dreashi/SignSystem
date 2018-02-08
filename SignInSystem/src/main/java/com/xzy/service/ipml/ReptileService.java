package com.xzy.service.ipml;


import com.xzy.model.News;
import com.xzy.service.IReptileService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class ReptileService implements IReptileService{

    private  static  String [] urls={"http://cul.qq.com/","http://tech.qq.com/","http://ent.qq.com/"};
    private  static  String [] regexs={"#news","#news","div.wrap"};
    private  static  String [] marks={"文化","科技","娱乐"};

    public List<News> initNewsList(){
        List<News> lists=null;
        for(int i=0;i<urls.length;++i) {
           List list = initNewsList(urls[i], regexs[i], marks[i]);
            if(lists==null)
                lists=list;
            lists.addAll(list);
        }
        System.out.println(lists.size());
        return  lists;
    }
    //根据url和 规则 爬取关键信息
    public List<News> initNewsList(String newsUrl,String regex,String mark){
        List<News> list = null;
        try {
                Document document = Jsoup.connect(newsUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36")
                    .cookie("auth", "token")
                    .timeout(30000)
                    .get();
            document = Jsoup.parse(document.toString());//匹配document的字符

            Elements element = document.select(regex);//根据传进的规则选取元素
      //      System.out.println(element);
            if (element != null) {
                list = new ArrayList<>();
                Elements links=null;
                Elements imgs=null;
                switch (mark){
                    case "文化":
                                links = element.select("div.Q-tpList").select("em").select("a");
                                imgs = element.select("div.Q-tpList").select("img");
                                break;
                    case "科技":
                                links = element.select("div.Q-tpList").select("h3.f18").select("a");
                                imgs = element.select("div.Q-tpList").select("img");
                                break;
                    case "娱乐":
                                links = element.select("div.Q-tpList").select("em").select("a");
                                imgs = element.select("div.Q-tpList").select("img");
                                break;
                }

                //System.out.println(links.size());
                list=getNewsList(links,imgs,mark);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public File getNewsAllContent(String url, String regex) {
        return null;
    }

    public List<News> getNewsList(Elements links,Elements imgs,String mark){
        List<News> list = new ArrayList<>();
        if(links==null || imgs==null)
            return list;
        Iterator iterLink = links.iterator();
        Iterator iterImg = imgs.iterator();
        News news = null;

        while(iterLink.hasNext() && iterImg.hasNext()){
            news = new News();
            Element link = (Element) iterLink.next();
            Element img = (Element) iterImg.next();
            news.setNewsMark(mark);
            news.setNewsKeyWord(link.text());
            if(!img.attr("src").equals(""))
                news.setNewsKeyImg(img.attr("src"));
            else
                news.setNewsKeyImg(img.attr("_src"));
            news.setNewsHref(link.attr("href"));
            list.add(news);
        }
        return list;
    }



}
