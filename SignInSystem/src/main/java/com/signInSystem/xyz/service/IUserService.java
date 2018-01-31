package com.signInSystem.xyz.service;

import com.signInSystem.xyz.model.Users;

public interface IUserService {
    public Users selectUser(String user_phone);
    public void insertUser(Users user);
    public int selectUserId(String user_phone);
}
