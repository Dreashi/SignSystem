package com.xzy.service;

import com.xzy.model.MessageOperate;

import java.util.List;

public interface IMessageOperateService {
    public boolean saveMessageOperate(MessageOperate messageOperate);
    public List<MessageOperate> loadAllMessageOperate(int userId);
}
