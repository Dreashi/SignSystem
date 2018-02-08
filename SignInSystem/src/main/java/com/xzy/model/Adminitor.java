package com.xzy.model;

import java.io.Serializable;

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

}
