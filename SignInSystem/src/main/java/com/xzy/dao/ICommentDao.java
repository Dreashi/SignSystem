package com.xzy.dao;


import com.xzy.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentDao {
    //加载帖子的评论
    public List<Comment> loadCommentsByPostId(int postId);
    //加载评论的回复
    public List<Comment> loadCommentsByParentCommentId(int parentCommentId);
    //按页加载评论
    public List<Comment> loadCommentPage(@Param("postId") int postId, @Param("page") int page);
    //通过id加载评论
    public Comment loadCommentByCommentId(int commentId);
    //发布评论
    public int sendCommentToPost(Comment comment);
    //进行回复
    public int sendCommentToComment(Comment comment);
    //增加评论数
    public int addCommentCount(int commentId);
    //加载帖子所有评论的评论id
    public List<Integer> loadCommentsIdByPostId(int postId);
    //通过父评论的id删除回复
    public int deleteCommentByParentCommentId(List<Integer> parentList);
    //通过评论id删除评论
    public int deleteCommentsById(List<Integer> commentIdList);
    //加载评论的点赞数
    public int loadSupportCount(int commentId);
    //增加点赞数
    public int addSupportCount(int commentId);
    //取消赞
    public int subSupportCount(int commentId);
}
