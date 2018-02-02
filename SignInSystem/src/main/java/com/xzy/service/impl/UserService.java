package com.xzy.service.impl;

import com.xzy.dao.IUserDao;
import com.xzy.entity.Group;
import com.xzy.entity.User;
import com.xzy.service.IGroupService;
import com.xzy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private  IUserDao userDao;
    @Autowired
   private IGroupService groupService;
@Override
public boolean updateUsersGroupId(String userPhone, int groupleaderId) {
        int userId = userDao.selectUserId(userPhone);
        int groupId = userDao.selectGroupId(groupleaderId);
        int res = userDao.updateGroupIdAddUsers(groupId,userId);
        return res > 0 ? true : false;
        }

@Override
public List<User> selectUsers(int groupID) {
        List<User> userList=userDao.selectUsers(groupID);

        int gLeaderId = groupService.selectGroupLeaderId(groupID).getGroupleaderId();
        User gLeader=null;
        Iterator<User> userIteratro=null;
        if (userList!=null) {
             userIteratro = userList.iterator();
        }
        if(gLeaderId!=0){
            while(userIteratro.hasNext()){
                User user =userIteratro.next();
                    if(user.getUserId() == gLeaderId) {
                        gLeader=user;
                        userIteratro.remove();
                    }
            }
             userList.add(0,gLeader);
        }
        return userList;
        }


}
