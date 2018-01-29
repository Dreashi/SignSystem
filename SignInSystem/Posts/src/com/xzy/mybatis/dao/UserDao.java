package com.xzy.mybatis.dao;

import com.xzy.web.entity.Comment;
import com.xzy.web.entity.Post;
import com.xzy.web.entity.User;

public interface UserDao {

    public User loadUserById(int userId);
    public Post sendPost();
    public Comment sendComment();
    public boolean deletePost(int postId);
    public boolean deleteComment(int commentId);
    public int SupportPost();
}
