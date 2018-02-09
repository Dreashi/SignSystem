package com.xzy.model;

import java.io.Serializable;
import java.util.List;

public class Comment implements Serializable{
    private int commentId;//评论id
    private int postId;//所评论的帖子的id
    private int parentCommentId;//所回复的评论的id
    private int commentSupports;//评论的点赞量
    private int commentCounts;
    private String commentDatetime;//评论的时间
    private String commentContentFile;//评论内容的文件
    private Users commentOwner;//发布评论的用户
    private List<Comment> sonCommentList;

    
    public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	

	public Comment(int commentId, int postId, int parentCommentId, int commentSupports, int commentCounts,
				   String commentDatetime, String commentContentFile, Users commentOwner, List<Comment> sonCommentList) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.parentCommentId = parentCommentId;
		this.commentSupports = commentSupports;
		this.commentCounts = commentCounts;
		this.commentDatetime = commentDatetime;
		this.commentContentFile = commentContentFile;
		this.commentOwner = commentOwner;
		this.sonCommentList = sonCommentList;
	}



	public Comment(int commentId, int postId, int parentCommentId, int commentSupports, String commentDatetime,
			String commentContentFile, Users commentOwner) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.parentCommentId = parentCommentId;
		this.commentSupports = commentSupports;
		this.commentDatetime = commentDatetime;
		this.commentContentFile = commentContentFile;
		this.commentOwner = commentOwner;
	}

	public Comment(Users commentOwner, int postId, int parentCommentId, String commentContentFile) {
		super();
		this.postId = postId;
		this.commentOwner = commentOwner;
		this.parentCommentId = parentCommentId;
		this.commentContentFile = commentContentFile;
	}

	public Comment(int postId, String commentContentFile, Users commentOwner) {
		this.postId = postId;
		this.commentContentFile = commentContentFile;
		this.commentOwner = commentOwner;
	}

	public Comment(Users commentOwner, int parentCommentId, String commentContentFile) {
		this.parentCommentId = parentCommentId;
		this.commentContentFile = commentContentFile;
		this.commentOwner = commentOwner;
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


	public Users getCommentOwner() {
		return commentOwner;
	}


	public void setCommentOwner(Users commentOwner) {
		this.commentOwner = commentOwner;
	}
	
	public List<Comment> getSonCommentList() {
		return sonCommentList;
	}
	
	public void setSonCommentList(List<Comment> sonCommentList) {
		this.sonCommentList = sonCommentList;
	}
	
	public int getCommentSupports() {
		return commentSupports;
	}

	public void setCommentSupports(int commentSupports) {
		this.commentSupports = commentSupports;
	}
	
	

	public int getCommentCounts() {
		return commentCounts;
	}



	public void setCommentCounts(int commentCounts) {
		this.commentCounts = commentCounts;
	}



	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", postId=" + postId + ", parentCommentId=" + parentCommentId
				+ ", commentSupports=" + commentSupports + ", commentCounts=" + commentCounts + ", commentDatetime="
				+ commentDatetime + ", commentContentFile=" + commentContentFile + ", commentOwner=" + commentOwner
				+ ", sonCommentList=" + sonCommentList + "]";
	}
	
}
