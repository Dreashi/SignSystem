package com.xzy.service.impl;

import com.xzy.dao.IUserDao;
import com.xzy.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {

    @Resource
    IUserDao userDao;

    @Override
    public boolean updateUsersGroupId(String userPhone, int groupleaderId) {
        int userId = userDao.findUsers(userPhone);
        int groupId = userDao.findGroupId(groupleaderId);
        int res = userDao.updateUsersGroupId(groupId,userId);
        return res > 0 ? true : false;
    }
}
