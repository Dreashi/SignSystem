package com.xzy.service;

import com.xzy.model.SignIn;
import org.apache.shiro.dao.DataAccessException;

import java.util.List;

public interface ISignInService {
    public List<SignIn> select(int userId);
    public List<SignIn> select(String signInDate);
    public List<SignIn> selectByGroupId(int userId);
    boolean update(String signInTime,int userId)throws DataAccessException;
    boolean update(int userId) throws DataAccessException;
}
