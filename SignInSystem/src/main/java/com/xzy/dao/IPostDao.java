package com.xzy.dao;


import com.xzy.model.Post;

import java.util.List;

public interface IPostDao {

    //按时间加载所有帖子
    public List<Post> loadAllPostByTime();
    //按热度加载所有帖子
    public List<Post> loadAllPostByHeat();
    //加载自己的帖子
    public List<Post> loadPostById(int userId);
    //发帖子
    public int sendPost(Post newPost);
    //删除帖子
    public int deletePost(int postId);
    //按页加载
    public List<Post> loadPostPage(int page);
    //增加点赞数
    public int addSupportCount(int postId);
    //取消赞
    public int subSupportCount(int postId);
    //加载点赞数
    public int  loadSupportCount(int postId);
    //增加评论数
    public int addCommentCount(int postId);

    Post loadByPostId(int postId);
}
