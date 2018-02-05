package com.signInSystem.xyz.service.ipml;

import com.signInSystem.xyz.dao.PasswordMapper;
import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.service.IPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("passwordService")

public class PasswordServiceImpl implements IPasswordService{

    @Resource
    private PasswordMapper passwordDao;
    @Override
    public void insertPasswords(UserPassword userPassword) {
        this.passwordDao.insertPasswords(userPassword);
    }

    @Override
    public String selectUserPassword(int user_id) {
       String password=null;
        try {
            password= this.passwordDao.selectUserPassword(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public int updateUserPassword(UserPassword userPassword) {
        int i=0;
        try {
            i=this.passwordDao.updateUserPassword(userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


}
