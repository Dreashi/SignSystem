package com.signInSystem.xyz.service.ipml;

import com.signInSystem.xyz.dao.PasswordAddSalt;
import com.signInSystem.xyz.dao.PasswordMapper;
import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;
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
    public String selectTrueUserPassword(int user_id) {
        String password=this.passwordDao.selectTrueUserPassword(user_id);
        return password;
    }
}
