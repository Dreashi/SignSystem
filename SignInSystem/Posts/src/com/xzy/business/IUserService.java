package com.xzy.business;

import com.xzy.web.entity.User;

public interface IUserService {

    public User loadUserById(int userId);
}
