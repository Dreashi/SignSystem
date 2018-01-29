package com.xzy.mybatis.dao;

import com.xzy.web.entity.Post;

import java.util.List;

public interface PostDao {

    //加载所有帖子
    public List<Post> loadAllPost();
    //加载自己的帖子
    public List<Post> loadPostById(int userId);
    //发帖子
    public boolean sendPost(Post newPost);
    //删除帖子
    public int deletePost(List<Integer> ids);
    //点赞
    public int SupportPost();
}
