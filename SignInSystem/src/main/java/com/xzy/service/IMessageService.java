package com.xzy.service;

import com.xzy.model.Message;

import java.util.List;

public interface IMessageService {
    public Message loadByMessageId(int messageId);

    public List<Message> loadByUserId(int userId);

    public boolean saveMessage(Message message);

    public boolean deleteMessage(Message message);

    public List<Message> loadOnlyMyMessage(int userId);
}
