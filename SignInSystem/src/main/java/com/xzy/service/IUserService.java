package com.xzy.service;

import com.xzy.dao.IUserDao;

public interface IUserService {
    //User 电话号码 ，session中的组长id
    public boolean updateUsersGroupId(String userPhone,int groupleaderId);
}
