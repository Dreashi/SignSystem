package com.xzy.dao;


import com.xzy.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    //    public List<User> loadAll();
//    public User loadByPhone(int userPhone);
//    public int update(User user);
    public int selectUserId(String userPhone);
    public int selectGroupId(int groupleaderId);
    public int updateGroupIdAddUsers(@Param(value = "groupId") int groupId, @Param(value = "userId") int userId);
    public int updateGroupIdDeleteUsers(int userId[]);
    public List<User> selectUsers(int groupId);
}
