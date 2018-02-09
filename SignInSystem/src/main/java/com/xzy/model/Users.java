package com.xzy.model;

import java.io.Serializable;

public class Users implements Serializable {
    private int userId;
    private String userName;
    private String userPhone;
    private String userQQ;
    private String userEmail;
    private String userBirthday;
    private int groupId;
    private String userImage;
    private String userSex;

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

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Users(int userId, String userName, String userPhone, String userQQ, String userEmail, String userBirthday, int groupId, String userImage, String userSex) {

        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userQQ = userQQ;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.groupId = groupId;
        this.userImage = userImage;
        this.userSex = userSex;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", groupId=" + groupId +
                ", userImage='" + userImage + '\'' +
                ", userSex='" + userSex + '\'' +
                '}';
    }
}
