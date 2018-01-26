package com.xyz.service.ipml;

import com.xyz.dao.IUserDao;
import com.xyz.model.User;
import com.xyz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {

        return this.userDao.selectUser(userId);
    }

}
