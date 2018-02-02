package com.xzy.service;

import com.xzy.dao.IUserDao;
import com.xzy.entity.User;

import java.util.List;

public interface IUserService {
    //User 电话号码 ，session中的组长id
    public boolean updateUsersGroupId(String userPhone,int groupleaderId);
    public List<User> selectUsers(int groupID);
}
