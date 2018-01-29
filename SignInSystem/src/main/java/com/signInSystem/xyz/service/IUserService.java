package com.signInSystem.xyz.service;

import com.signInSystem.xyz.model.Register;
import com.signInSystem.xyz.model.Users;

public interface IUserService {
    public Users selectUser(long userId);
    public void insertUser(Register user);
    public int selectPassword(String user_phone);
}
