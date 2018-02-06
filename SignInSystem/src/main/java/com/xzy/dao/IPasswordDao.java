package com.xzy.dao;

import com.xzy.model.UserPassword;

public interface IPasswordDao {
    public void insertPasswords(UserPassword userPassword);
    public String selectUserPassword(int userId);
    public int updateUserPassword(UserPassword userPassword);
}
