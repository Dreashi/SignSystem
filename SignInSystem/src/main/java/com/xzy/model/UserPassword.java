package com.xzy.model;

public class UserPassword {
    int pwdId;
    String userPwd;
    int userId;

    public int getPwdId() {
        return pwdId;
    }

    public void setPwdId(int pwdId) {
        this.pwdId = pwdId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserPassword() {
    }

    public UserPassword(int pwdId, String userPwd, int userId) {
        this.pwdId = pwdId;
        this.userPwd = userPwd;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "pwdId=" + pwdId +
                ", userPwd='" + userPwd + '\'' +
                ", userId=" + userId +
                '}';
    }
}
