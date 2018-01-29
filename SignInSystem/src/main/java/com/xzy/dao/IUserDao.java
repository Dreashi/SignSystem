package com.xzy.dao;


import org.apache.ibatis.annotations.Param;

public interface IUserDao {
    //    public List<User> loadAll();
//    public User loadByPhone(int userPhone);
//    public int update(User user);
    public int findUsers(String userPhone);
    public int findGroupId(int groupleaderId);
    public int updateUsersGroupId(@Param(value = "groupId") int groupId, @Param(value = "userId") int userId);

}
