package com.xzy.dao;

import com.xzy.model.Message;

import java.util.List;

public interface IMessageDao{
    public Message loadByMessageId(int messageId);

    public List<Message> loadByUserId(int userId);

    public int saveMessage(Message message);

    public int deleteMessage(Message message);
}
