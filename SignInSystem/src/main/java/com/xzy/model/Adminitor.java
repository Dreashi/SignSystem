package com.xzy.model;

import java.io.Serializable;

<<<<<<< HEAD
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
=======
public class Adminitor implements Serializable{
private int	adminId ;
private String	 adminName ;
private int	  userId ;
private String	  adminPhone ;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAdminPhone() {
	return adminPhone;
}
public void setAdminPhone(String adminPhone) {
	this.adminPhone = adminPhone;
}

>>>>>>> GHH
}
