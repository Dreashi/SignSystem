package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;

public interface PasswordMapper {
    public void insertPasswords(UserPassword userPassword);
    public String selectUserPassword(int user_id);
    public int updateUserPassword(UserPassword userPassword);
}
