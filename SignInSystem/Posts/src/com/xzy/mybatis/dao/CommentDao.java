package com.xzy.mybatis.dao;

import com.xzy.web.entity.Comment;

import java.util.List;

public interface CommentDao {
    //加载评论
    public List<Comment> loadAllComment();
    //删除评论
    public boolean deleteComment(int commentId);
    //发布评论
    public Comment sendComment();
}
