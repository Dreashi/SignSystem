package com.xzy.service.ipml;

import com.xzy.dao.IMessageOperateDao;
import com.xzy.model.MessageOperate;
import com.xzy.service.IMessageOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageOperateService implements IMessageOperateService {
    @Autowired
    private IMessageOperateDao messageOperateDao;
    @Override
    public boolean saveMessageOperate(MessageOperate messageOperate) {
        int count =messageOperateDao.saveMessageOperate(messageOperate);
        return count>0?true:false;
    }

    @Override
    public List<MessageOperate> loadAllMessageOperate(int userId) {
        return messageOperateDao.loadByUserId(userId);
    }
}
