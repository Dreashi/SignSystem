package com.signInSystem.xyz.service;

import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;

public interface IPasswordService {
    public void insertPasswords(UserPassword userPassword);
    public String selectUserPassword(int user_id);
}
