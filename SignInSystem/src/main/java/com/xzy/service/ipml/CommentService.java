package com.xzy.service.ipml;


import com.xzy.dao.ICommentDao;
import com.xzy.dao.ICommentStatusDao;
import com.xzy.dao.IPostDao;
import com.xzy.model.Comment;
import com.xzy.model.CommentStatus;
import com.xzy.model.Users;
import com.xzy.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService implements ICommentService {
	@Autowired
	private ICommentDao commentDao;
	@Autowired
	private IPostDao postDao;
	@Autowired
	private ICommentStatusDao commentStatusDao;


	//对帖子进行评论ok
	public boolean sendCommentToPost(int userId, String userName, int postId, String content){
		Users user=new Users(userId, userName);
		Comment newComment=new Comment(postId, content, user);
		int count=commentDao.sendCommentToPost(newComment);
		postDao.addCommentCount(postId);
		return count>0?true:false;
	}

	//对评论进行回复
	public boolean sendCommentToComment(int userId, String userName, int commentId, String content){
		int parentCommentId;
		Users user=new Users(userId, userName);
		Comment comment=commentDao.loadCommentByCommentId(commentId);
		if(comment.getParentCommentId()!=0 && comment.getPostId()==0){
			parentCommentId=comment.getParentCommentId();
		}else{
			parentCommentId=commentId;
		}
		Comment newComment=new Comment(user, parentCommentId,content);
		int count=commentDao.sendCommentToComment(newComment);
		if(count>0) {
			count=commentDao.addCommentCount(commentId);
		}
		return count>0?true:false;
	}

    //加载帖子的评论ok
	@Override
	public List<Comment> loadCommentsByPostId(int postId) {
		return commentDao.loadCommentsByPostId(postId);
	}

	//加载评论的回复
	@Override
	public List<Comment> loadCommentsByParentCommentId(int parentCommentId) {
		return commentDao.loadCommentsByParentCommentId(parentCommentId);
	}

	//按页加载评论
	@Override
	public List<Comment> loadCommentPage(int postId, int page) {
		int fPage=(page-1)*10;
		return commentDao.loadCommentPage(postId, fPage);
	}

	//加载评论的点赞数
	@Override
	public int loadSupportCount(int commentId) {
		return commentDao.loadSupportCount(commentId);
	}

	//对评论(回复)点赞
	@Override
	public int addSupportToComment(int userId, int commentId) {
		CommentStatus commentStatus=new CommentStatus(userId, commentId);
		int count=commentStatusDao.insertCommentStatus(commentStatus);
		if(count>0) {
			count = commentDao.addSupportCount(commentId);
			if(count>0) {
				count = commentDao.loadSupportCount(commentId);
			}
			else count=-1;
		}else count=-1;
		return count;
	}

	//取消对帖子(回复)的赞
	@Override
	public int subSupportToComment(int userId, int commentId) {
		CommentStatus commentStatus=new CommentStatus(userId, commentId);
		int count=commentStatusDao.deleteCommentStatus(commentStatus);
		if(count>0) {
			count = commentDao.subSupportCount(commentId);
			if(count>0) {
				count = commentDao.loadSupportCount(commentId);
			} else count=-1;
		}else count=-1;
		return count;
	}
}
