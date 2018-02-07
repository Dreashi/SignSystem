package com.xzy.service.ipml;

import com.xzy.dao.IUserDao;
import com.xzy.model.User;
import com.xzy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService{
        @Autowired
        private IUserDao userDao;
        @Override
        public User loadUserPhone(String userPhone){
           User userP  =  userDao.loadUserPhone(userPhone);
          return userP;
}
}
