package com.signInSystem.xyz.service.ipml;

import com.signInSystem.shiro.realms.ShiroRealm;
import com.signInSystem.xyz.dao.UserMapper;
import com.signInSystem.xyz.model.Register;
import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IUserService;
import com.signInSystem.xyz.service.email.MyEailUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userDao;

    @Override
    public Users selectUser(String userPhone){
        Users user = null;
        try {
            user=this.userDao.selectUser(userPhone);
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
    public int selectUserId(String userPhone) {
        int id=0;
        try {
           id= this.userDao.selectUserId(userPhone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public boolean doRegister(Register register){
        boolean bool=false;
        try {
            String string =  register.getUserPassword();
            Object result = ShiroRealm.MD5Encryption(string);
            System.out.println("---------------------------->"+result);
            userDao.insertRegister(register);
            //发送邮件
            MyEailUtil.sendEmail(register.getUserEmail(),register.getUserName(),"新卓越","请点击认证");
            bool=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public void insertRegister(Register register) {

    }

    @Override
    public int selectRegisterId(Register register) {
        return 0;
    }

    @Override
    public int selectRegisterEmail(Register register) {
        int i=0;
        try {
            i= this.userDao.selectRegisterEmail(register);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
