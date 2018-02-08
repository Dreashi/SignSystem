package com.xzy.service.ipml;


import com.xzy.dao.ICommentStatusDao;
import com.xzy.service.ICommentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentStatusService implements ICommentStatusService {
	@Autowired
	public ICommentStatusDao commentStatusDao;

	//加载评论的点赞状态
	@Override
	public List<Integer> loadCommentStatus(int userId, int postId) {
		return commentStatusDao.loadCommentStatus(userId,postId);
	}

}
