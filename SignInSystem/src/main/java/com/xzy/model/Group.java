package com.xzy.model;

import java.io.Serializable;

public class Group implements Serializable {
	private Integer groupId;
	private String groupName;
	private String groupDirect;
	private Integer groupLeaderId;

	public Group(Integer groupId, Integer groupLeaderId) {
		this.groupId = groupId;
		this.groupLeaderId = groupLeaderId;
	}

	public Group() {
	}

	@Override

	public String toString() {
		return "Group{" +
				"groupId=" + groupId +
				", groupName='" + groupName + '\'' +
				", groupDirect='" + groupDirect + '\'' +
				", groupLeaderId=" + groupLeaderId +
				'}';
	}

	public Group(Integer groupId, String groupName, String groupDirect, Integer groupLeaderId) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDirect = groupDirect;
		this.groupLeaderId = groupLeaderId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDirect() {
		return groupDirect;
	}

	public void setGroupDirect(String groupDirect) {
		this.groupDirect = groupDirect;
	}

	public Integer getGroupLeaderId() {
		return groupLeaderId;
	}

	public void setGroupLeaderId(Integer groupLeaderId) {
		this.groupLeaderId = groupLeaderId;
	}
}
