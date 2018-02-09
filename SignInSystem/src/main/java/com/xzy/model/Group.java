package com.xzy.model;

import java.io.Serializable;

public class Group implements Serializable {

    private int groupId;
    private String groupName;
    private String groupDirect;
    private int groupLeaderId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
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

    public int getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(int groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
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


	public Group(int groupId, int groupLeaderId) {
		this.groupId = groupId;
		this.groupLeaderId = groupLeaderId;
	}

	public Group() {
	}

	public Group(int groupId, String groupName, String groupDirect, int groupLeaderId) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDirect = groupDirect;
		this.groupLeaderId = groupLeaderId;
	}



}
