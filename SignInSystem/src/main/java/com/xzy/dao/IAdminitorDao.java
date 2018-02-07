package com.xzy.dao;

import com.xzy.model.Group;
import com.xzy.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminitorDao {
    public List<User> loadAll();
    public User loadByPhone(String userPhone);
     public int updateUser(Group group);
}
