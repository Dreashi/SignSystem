package com.xzy.model;

public class CommentStatus {
	
	private int userId;
	private int commentId;
	public CommentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentStatus(int userId, int commentId) {
		super();
		this.userId = userId;
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	@Override
	public String toString() {
		return "Commentstatus [userId=" + userId + ", commentId=" + commentId + "]";
	}
	
	

}
