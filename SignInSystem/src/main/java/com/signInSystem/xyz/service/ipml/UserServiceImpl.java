package com.signInSystem.xyz.service.ipml;

import com.signInSystem.xyz.dao.UserMapper;
import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userDao;

    @Override
    public Users selectUser(String user_phone){
        Users user = null;
        try {
            user=this.userDao.selectUser(user_phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public void insertUser(Users user){
        try {
            this.userDao.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int selectUserId(String user_phone) {
        int id=0;
        try {
           id= this.userDao.selectUserId(user_phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


}
