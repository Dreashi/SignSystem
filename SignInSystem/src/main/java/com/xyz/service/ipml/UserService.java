package com.xyz.service.ipml;

import com.xyz.dao.UserDao;
import com.xyz.model.User;
import com.xyz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService{
        @Autowired
        private UserDao userDao;
        @Override
        public User loadUserPhone(String userPhone){
           User userP  =  userDao.loadUserPhone(userPhone);
          return userP;
}
}
