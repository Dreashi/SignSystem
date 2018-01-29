package com.xyz.service.ipml;


import com.xyz.dao.ISignInDao;
import com.xyz.model.SignIn;
import com.xyz.service.ISignInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("signInService")
public class SignInServiceImpl implements ISignInService{

    @Resource
    private ISignInDao signInDao;


    @Override
    public List<SignIn> select(int userId) {
        return this.signInDao.selectById(userId);
    }

    @Override
    public List<SignIn> select(String signInDate) {
        return this.signInDao.selectByDate(signInDate);
    }

    @Override
    public List<SignIn> select(String signInDate, int userId) {
        return this.signInDao.selectByGroupIdAndDate(signInDate,userId);
    }

    @Override
    public boolean insert(int userId,String SignInTime) {
        int rows = this.signInDao.insertInToSignIn(userId,SignInTime);
        if (rows > 0)
            return true;
        return false;
    }

}
