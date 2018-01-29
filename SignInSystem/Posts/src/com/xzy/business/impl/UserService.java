package com.xzy.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzy.business.IUserService;
import com.xzy.mybatis.dao.UserDao;
import com.xzy.web.entity.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;

    public User loadUserById(int userId) {
        return userDao.loadUserById(userId);
    }
}
