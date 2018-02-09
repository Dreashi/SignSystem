package com.xzy.service;

import com.xzy.model.Adminitor;

import com.xzy.model.Group;
import com.xzy.model.Users;


import java.util.List;

public interface IAdminitorService {

    public boolean loadByUserId(int userId);
    public List<Adminitor> loadAllAdminitor();

   public List<Users> loadAll();
    public boolean loadByPhone(String userPhone);
    public boolean update(Group group);
    public boolean updateLeader(List<Integer> listLeader);
    public boolean updateUser(Group group);
    public List<Group> loadAllGroup();
    public List<Integer> loadAllLeaderId();
    public boolean insertLeader(Group group);

}
