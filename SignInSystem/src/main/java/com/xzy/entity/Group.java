package com.xzy.entity;

public class Group {
    private int	      groupId ;
    private String	  groupName;
    private String	  groupDirect;
    private int	      groupleaderId ;
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
    public int getGroupleaderId() {
        return groupleaderId;
    }
    public void setGroupleaderId(int groupleaderId) {
        this.groupleaderId = groupleaderId;
    }
}
