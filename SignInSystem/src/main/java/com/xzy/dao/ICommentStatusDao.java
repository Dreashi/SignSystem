package com.xzy.dao;

import com.xzy.model.CommentStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentStatusDao {

	//加载评论的点赞状态
	public List<Integer> loadCommentStatus(@Param("userId") int userId, @Param("postId") int postId);
	//对评论点赞
	public  int insertCommentStatus(CommentStatus commentStatus);
	//取消对评论的赞
	public  int deleteCommentStatus(CommentStatus commentStatus);

}
