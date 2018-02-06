package com.xzy.service.ipml;


import com.xzy.dao.ISignInDao;
import com.xzy.model.SignIn;
import com.xzy.service.ISignInService;
import org.apache.shiro.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
    public List<SignIn> selectByGroupId(int userId) {
        return this.signInDao.selectByGroupIdAndDate(userId);
    }

    @Override
    public boolean update(String SignInTime,int userId) throws DataAccessException{
        int rows = this.signInDao.updateSignInStatusByUsers(SignInTime,userId);
        return rows > 0 ? true : false;
    }

    @Override
    @Transactional
    public boolean update(int userId) throws DataAccessException{
        int rows = this.signInDao.updateSignInStatusByAdmin(userId);
        return rows > 0 ? true : false;
    }

}
