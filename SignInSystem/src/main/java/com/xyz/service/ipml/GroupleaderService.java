package com.xyz.service.ipml;


import com.xyz.dao.IGroupleaderDao;
import com.xyz.model.Group;
import com.xyz.model.User;

import java.util.List;


public class GroupleaderService implements IGroupleaderDao{

    @Override
    public List<User> loadAll() {
        return null;
    }

    @Override
    public User loadByPhone(String userPhone) {
        return null;
    }

    @Override
    public Group loadByLeaderId(String groupLeaderId) {
        return null;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int updateLeader(Group group) {
        return 0;
    }
}
