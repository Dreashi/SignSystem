package com.xzy.dao;

import com.xzy.model.MessageOperate;

import java.util.List;

public interface IMessageOperateDao {
    public int saveMessageOperate(MessageOperate messageOperate);
    public List<MessageOperate> loadByUserId(int userId);
}
