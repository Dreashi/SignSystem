package com.xzy.model;

import java.io.Serializable;


public class SignIn implements Serializable {
    private int userId;
    private String userName;
    private String signInDate;
    private String signInTime;
    private String signInStatus;

    @Override
    public String toString() {
        return "SignIn{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", signInDate=" + signInDate +
                ", signInTime=" + signInTime +
                ", signInStatus='" + signInStatus + '\'' +
                '}';
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

    public String getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(String signInDate) {
        this.signInDate = signInDate;
    }

    public String getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(String signInTime) {
        this.signInTime = signInTime;
    }

    public String getSignInStatus() {
        return signInStatus;
    }

    public void setSignInStatus(String signInStatus) {
        this.signInStatus = signInStatus;
    }
}
