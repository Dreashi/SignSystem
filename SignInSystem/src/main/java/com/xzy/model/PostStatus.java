package com.xzy.model;

public class PostStatus {
	private int userId;
	private int postId;
	
	
	public PostStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostStatus(int userId, int postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	@Override
	public String toString() {
		return "PostStatus [userId=" + userId + ", postId=" + postId + "]";
	}
	
	

}
