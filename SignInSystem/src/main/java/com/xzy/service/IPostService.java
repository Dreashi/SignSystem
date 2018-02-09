package com.xzy.service;


import com.xzy.model.Post;

import java.util.List;

public interface IPostService {

    //加载所有帖子并按时间排序
    public List<Post> loadAllPostByTime();
    //加载所有帖子并按热度排序
    public List<Post> loadAllPostByHeat();
    //加载当前用户的帖子
    public List<Post> loadPostById(int userId);
    //发帖子
    public boolean sendPost(int userId, String content);
    //按页加载
    public List<Post> loadPostPage(int page);
    //删帖子
    public boolean deletePost(int postId);
    //对帖子点赞
    public int addSupportToPost(int userId, int postId);
    //取消对帖子的点赞
    public int subSupportToPost(int userId, int postId);

}
