package com.xzy.web.entity;

import java.io.Serializable;
import java.util.List;

public class Comment implements Serializable{
    private int commentId;//评论id
    private int postId;//所评论的帖子的id
    private int parentCommentId;//所回复的评论的id
    private String commentDatetime;//评论的时间
    private String commentContentFile;//评论内容的文件
    private User commentOwner;//发布评论的用户
    private List<Comment> sonCommentList;

    
    public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
    


	public Comment(int commentId, int postId, int parentCommentId, String commentDatetime, String commentContentFile,
			User commentOwner, List<Comment> sonCommentList) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.parentCommentId = parentCommentId;
		this.commentDatetime = commentDatetime;
		this.commentContentFile = commentContentFile;
		this.commentOwner = commentOwner;
		this.sonCommentList = sonCommentList;
	}



	public int getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public int getParentCommentId() {
		return parentCommentId;
	}


	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}


	public String getCommentDatetime() {
		return commentDatetime;
	}


	public void setCommentDatetime(String commentDatetime) {
		this.commentDatetime = commentDatetime;
	}


	public String getCommentContentFile() {
		return commentContentFile;
	}


	public void setCommentContentFile(String commentContentFile) {
		this.commentContentFile = commentContentFile;
	}


	public User getCommentOwner() {
		return commentOwner;
	}


	public void setCommentOwner(User commentOwner) {
		this.commentOwner = commentOwner;
	}
	
	public List<Comment> getSonCommentList() {
		return sonCommentList;
	}
	
	public void setSonCommentList(List<Comment> sonCommentList) {
		this.sonCommentList = sonCommentList;
	}



	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", postId=" + postId + ", parentCommentId=" + parentCommentId
				+ ", commentDatetime=" + commentDatetime + ", commentContentFile=" + commentContentFile
				+ ", commentOwner=" + commentOwner + ", sonCommentList=" + sonCommentList + "]";
	}
	
    
}
