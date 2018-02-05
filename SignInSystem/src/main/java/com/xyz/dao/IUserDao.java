package com.xyz.dao;

import com.xyz.model.User;

public interface IUserDao {

    User selectById(int userId);
    String selectNameById();
}
