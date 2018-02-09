package com.xzy.service;

import java.util.List;


public interface IPostStatusService {

	//加载帖子的点赞状态
	public List<Integer> loadPostStatus(int userId);

}
