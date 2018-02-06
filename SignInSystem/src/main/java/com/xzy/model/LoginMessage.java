package com.xzy.model;

public class LoginMessage {
    private String userPhone;
    private String userPwd;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "userPhone='" + userPhone + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}

