package com.xzy.model;


import java.io.Serializable;

public class MessageOperate implements Serializable {
    private int operateId;
    private int userId;
    private int messageId;

    public int getOperateId() {
        return operateId;
    }

    public void setOperateId(int operateId) {
        this.operateId = operateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "MessageOperate{" +
                "operateId=" + operateId +
                ", userId=" + userId +
                ", messageId=" + messageId +
                '}';
    }
}

