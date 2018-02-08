package com.xzy.controller;


import com.xzy.model.Comment;
import com.xzy.service.ICommentService;
import com.xzy.service.ICommentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CommentController {
	@Autowired
	private ICommentService commentService;
	@Autowired
	private ICommentStatusService commentStatusService;

	//对帖子评论ok
	@RequestMapping("/sendCommentToPostHandler")
	@ResponseBody
	public boolean sendCommentToPostHandler(@RequestParam("userId")int userId,
										   @RequestParam("userName")String userName,
										   @RequestParam("postId")int postId,
										   @RequestParam("content")String content) {
		boolean bool=commentService.sendCommentToPost(userId, userName, postId,content);
		return bool;
	}

	//对评论进行回复ok
	@RequestMapping("/sendCommentToCommentHandler")
	@ResponseBody
	public boolean sendCommentToCommentHandler(@RequestParam("userId")int userId,
											  @RequestParam("userName")String userName,
											  @RequestParam("commentId")int commentId,
											  @RequestParam("content")String content) {
		boolean bool=commentService.sendCommentToComment(userId, userName, commentId, content);
		return bool;
	}

	//加载帖子的评论ok
	@RequestMapping("/loadCommentsByPostIdHandler")
	@ResponseBody
	public List<Comment> loadCommentsByPostIdHandler(@RequestParam("postId")int postId) {
			List<Comment> postCommentsList=commentService.loadCommentsByPostId(postId);
//			List<Integer> commentStatus=commentStatusService.loadCommentStatus(userId,postId);
//			Map<List, List> commentMap = new HashMap<>();
//			commentMap.put(postCommentsList, commentStatus);
		return postCommentsList;
	}

	//按页加载评论OK
	@RequestMapping("/loadCommentPageHandler")
	@ResponseBody
	public List<Comment> loadCommentPageHandler(@RequestParam("postId") int postId, @RequestParam("page") int page){
		List<Comment> commentList=commentService.loadCommentPage(postId,page);
		return commentList;
	}



	//加载评论的所有回复
	@RequestMapping("/loadCommentByParentCommentIdHandler")
	@ResponseBody
	public List<Comment> loadCommentByParentCommentIdHandler(@RequestParam("id")int commentId) {
			List<Comment> commentCommentsList=commentService.loadCommentsByParentCommentId(commentId);
		return commentCommentsList;
	}

	//对评论或回复点赞ok
	@RequestMapping("/addSupportToCommentHandler")
	@ResponseBody
	public int addSupportToCommentHandler(@RequestParam("userId") int userId, @RequestParam("commentId") int commentId) {
		return commentService.addSupportToComment(userId,commentId);
	}

	//取消对帖子或评论的点赞ok
	@RequestMapping("/subSupportToCommentHandler")
	@ResponseBody
	public int subSupportToCommentHandler(@RequestParam("userId") int userId, @RequestParam("commentId") int commentId){
		return commentService.subSupportToComment(userId, commentId);
	}
	

}
