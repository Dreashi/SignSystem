package com.xyz.dao;

import com.xyz.model.User;

public interface IUserDao {

    User selectUser(long id);
}
