package com.xzy.web.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private int userId;
    private String userName;
    private String userPhone;
    private String userQQ;
    private String userEmail;
    private String userSex;
    private String userBirthday;
    private String userImage;
    private int groupId;
    private List<Post> postList;

    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String userPhone, String userQQ, String userEmail, String userSex,
			String userBirthday, String userImage, int groupId, List<Post> postList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userQQ = userQQ;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userImage = userImage;
		this.groupId = groupId;
		this.postList = postList;
	}
	
	public User(int userId, String userName, String userPhone, String userQQ, String userEmail, String userSex,
			String userBirthday, String userImage, int groupId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userQQ = userQQ;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userImage = userImage;
		this.groupId = groupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userQQ=" + userQQ
				+ ", userEmail=" + userEmail + ", userSex=" + userSex + ", userBirthday=" + userBirthday
				+ ", userImage=" + userImage + ", groupId=" + groupId + ", postList=" + postList + "]";
	}

	
	
    
}
