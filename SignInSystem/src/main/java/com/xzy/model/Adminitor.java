package com.xzy.model;

import java.io.Serializable;


public class Adminitor implements Serializable {
    private int adminitorId;
    private String adminitorName;
    private String adminitorPhone;
    private int userId;

    public int getAdminitorId() {
        return adminitorId;
    }

    public void setAdminitorId(int adminitorId) {
        this.adminitorId = adminitorId;
    }

    public String getAdminitorName() {
        return adminitorName;
    }

    public void setAdminitorName(String adminitorName) {
        this.adminitorName = adminitorName;
    }

    public String getAdminitorPhone() {
        return adminitorPhone;
    }

    public void setAdminitorPhone(String adminitorPhone) {
        this.adminitorPhone = adminitorPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Adminitor{" +
                "adminitorId=" + adminitorId +
                ", adminitorName='" + adminitorName + '\'' +
                ", adminitorPhone='" + adminitorPhone + '\'' +
                ", userId=" + userId +
                '}';
    }
}
