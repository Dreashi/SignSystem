package com.xzy.service;


import com.xzy.model.Comment;

import java.util.List;

public interface ICommentService {

    //加载帖子的评论
    public List<Comment> loadCommentsByPostId(int postId);
    //加载评论的回复
    public List<Comment> loadCommentsByParentCommentId(int parentCommentId);
    //按页加载评论
    public List<Comment> loadCommentPage(int postId, int page);
    //发送评论
    public boolean sendCommentToPost(int userId, String userName, int postId, String content);
    //对评论回复
    public boolean sendCommentToComment(int userId, String userName, int commentId, String content);
    //加载评论的点赞数
    public int loadSupportCount(int commentId);
    //对评论或回复点赞
    public int addSupportToComment(int userId, int commentId);
    //取消对评论或回复的赞
    public int subSupportToComment(int userId, int commentId);
}
