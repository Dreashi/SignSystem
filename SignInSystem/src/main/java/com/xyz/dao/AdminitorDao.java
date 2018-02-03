package com.xyz.dao;

import com.xyz.model.Group;
import com.xyz.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminitorDao {
    public List<User> loadAll();
    public User loadByPhone(String userPhone);
     public int updateUser(Group group);
}
