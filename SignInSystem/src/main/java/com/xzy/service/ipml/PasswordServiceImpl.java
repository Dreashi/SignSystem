package com.xzy.service.ipml;

import com.xzy.dao.IPasswordDao;
import com.xzy.model.UserPassword;
import com.xzy.service.IPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("passwordService")
public class PasswordServiceImpl implements IPasswordService {

    @Resource
    private IPasswordDao passwordDao;
    @Override
    public void insertPasswords(UserPassword userPassword) {
        this.passwordDao.insertPasswords(userPassword);
    }

    @Override
    public String selectUserPassword(int userId) {
       String password=null;
        try {
            password= this.passwordDao.selectUserPassword(userId);
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
