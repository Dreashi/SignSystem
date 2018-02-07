package com.xzy.service;

import com.xzy.model.UserPassword;

public interface IPasswordService {
    public void insertPasswords(UserPassword userPassword);
    public String selectUserPassword(int userId);
    public int updateUserPassword(UserPassword userPassword);
}
