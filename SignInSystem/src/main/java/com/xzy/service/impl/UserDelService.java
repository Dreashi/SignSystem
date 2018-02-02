package com.xzy.service.impl;

import com.xzy.dao.IUserDao;
import com.xzy.service.IUserDelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("IUserDelService")
public class UserDelService implements IUserDelService {
    @Resource
    IUserDao userDao;
    @Override
    public boolean updateUsersGroupId(int userId[]) {
//        String str="";
//       for(int i=0;i<userId.length-1;i++) {
//           str = String.valueOf(userId[i]) +",";
//           str=str+"";
//       }
//       str=str+String.valueOf(userId[userId.length-1]);
       int res=userDao.updateGroupIdDeleteUsers(userId);

       return res > 0? true : false;

    }
}
