package com.xzy.service;

import java.io.File;
import java.util.List;

public interface IReptileService {
    public  List initNewsList();
    public List initNewsList(String newsUrl, String regex, String mark);
    public File getNewsAllContent(String url, String regex);
}
