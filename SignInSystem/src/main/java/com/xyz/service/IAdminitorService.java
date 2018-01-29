package com.xyz.service;

import com.xyz.model.Group;
import com.xyz.model.User;

import java.util.List;

public interface IAdminitorService {
    public List<User> loadAll();
    public boolean loadByPhone(String userPhone);
    public boolean loadByLeaderId(String groupLeaderId);
    public boolean delete(User user);
    public boolean update(User user);
    public boolean updateLeader(Group group);

}
