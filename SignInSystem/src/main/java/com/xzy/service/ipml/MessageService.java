package com.xzy.service.ipml;

import com.xzy.dao.IAdminitorDao;
import com.xzy.dao.IGroupDao;
import com.xzy.dao.IMessageDao;
import com.xzy.dao.IUserDao;
import com.xzy.model.Adminitor;
import com.xzy.model.Group;
import com.xzy.model.Message;
import com.xzy.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private IMessageDao messageDao;
    @Autowired
    private IAdminitorDao adminitorDao;
    @Autowired
    private IGroupDao groupDao;
    @Autowired
    private IUserDao userDao;

    @Override
    public Message loadByMessageId(int messageId) {
        Message message = messageDao.loadByMessageId(messageId);
        return message;
    }
    /**先判断是否是管理员
     * 然后判断是否是组长
     * 最后肯定是组员
     */
    @Override
    public List<Message> loadByUserId(int userId) {

        Adminitor adminitor;//管理员
        Group group;//组
        User user;//成员
        List<Adminitor> adminList=adminitorDao.loadAllAdminitor();//管理员列表
        List<Message> messList = new ArrayList<>();//消息表
        adminitor= adminitorDao.loadByUserId(userId);//根据Id去管理员表查找
        group = groupDao.loadByGroupLeaderId(userId);//根据Id去组表查找
        for (Adminitor admin : adminList)
            if(admin!=null) {
                List list =messageDao.loadByUserId(admin.getUserId());
                //System.out.println("admin"+list);
                if (list!=null)
                    messList.addAll(list);
            }
        if(adminitor!=null) //当前用户是管理员
            return messList;
        if(group!=null) {//当前用户是组长
            List list =messageDao.loadByUserId(group.getGroupLeaderId());
           // System.out.println("leader"+list);
            if (list!=null)
                messList.addAll(list);
            return messList;
        }else{//当前用户是组员

            int groupId= userDao.selectUserByUserId(userId).getGroupId();//拿到当前组员的组号
            int groupLeaderId = groupDao.loadByGroupId(groupId).getGroupLeaderId();//根据组号拿到组长Id
            List<Message> list =messageDao.loadByUserId(groupLeaderId);
           // System.out.println("user"+list);
            if(list != null)
                messList.addAll(list);
            return messList;
        }
    }


    @Override
    public boolean saveMessage(Message message) {
        if(message == null)
            return false;
        //判断当前消息是否是管理员或组长发送的
        Adminitor adminitor  = adminitorDao.loadByUserId(message.getUserId());
        Group group = groupDao.loadByGroupLeaderId(message.getUserId());
        int count =0;
        if(adminitor!=null){
            message.setUserPosition("管理员");
            count = messageDao.saveMessage(message);
        }
        else if(group!=null) {
            message.setUserPosition("组长");
            count = messageDao.saveMessage(message);
        }
        return count>0?true:false;
    }

    @Override
    public boolean deleteMessage(Message message) {
        int count =messageDao.deleteMessage(message);
        return count>0?true:false;
    }

    @Override
    public List<Message> loadOnlyMyMessage(int userId) {
        List<Message> list = messageDao.loadByUserId(userId);
        int count = list.size();
        return count>0?list:null;
    }
}
