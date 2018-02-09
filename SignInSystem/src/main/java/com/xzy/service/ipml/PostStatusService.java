package com.xzy.service.ipml;


import com.xzy.dao.IPostStatusDao;
import com.xzy.service.IPostStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostStatusService implements IPostStatusService {
	@Autowired
	private IPostStatusDao postStatusDao;

	//加载帖子的点赞状态
	@Override
	public List<Integer> loadPostStatus(int userId) {
		return postStatusDao.loadPostStatus(userId);
	}

}
