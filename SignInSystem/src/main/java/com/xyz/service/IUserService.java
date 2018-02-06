package com.xyz.service;

import com.xyz.model.User;

public interface IUserService {
    public User selectById(int userId);
    public String selectNameById();
}
