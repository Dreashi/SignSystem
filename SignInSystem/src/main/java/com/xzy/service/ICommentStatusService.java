package com.xzy.service;

import java.util.List;


public interface ICommentStatusService {
	//加载对评论或回复的点赞状态
	public List<Integer> loadCommentStatus(int userId, int postId);

}
