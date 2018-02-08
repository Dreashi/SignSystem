package com.xzy.dao;

import com.xzy.model.PostStatus;

import java.util.List;

public interface IPostStatusDao {

	//加载帖子的点赞状态
	public List<Integer> loadPostStatus(int userId);
	//对帖子点赞
	public int insertPostStatus(PostStatus postStatus);
	//取消对帖子的赞
	public int deletePostStatus(PostStatus postStatus);

}
