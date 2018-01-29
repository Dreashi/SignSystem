package com.xyz.dao;

import com.xyz.model.Group;
import com.xyz.model.User;

import java.util.List;

public interface IGroupleaderDao {
    public List<User> loadAll();
    public User loadByPhone(String userPhone);
    public Group loadByLeaderId(String groupLeaderId);
    public int delete(User user);
    public int update(User user);
    public int updateLeader(Group group);
}

