package com.xyz.dao;



import com.xyz.model.Group;

import java.util.List;

public interface GroupDao {
    public int update(Group group);
    public int updateLeader(List<Integer> listLeader);
    public List<Group> loadAllGroup();
    public List<Integer> loadAllLeaderId();
    public int insertLeader(Group group);
    public Group loadByGroupLeader(int groupLeaderId);
}
