package com.xzy.dao;



import com.xzy.model.Group;

import java.util.List;

public interface IGroupDao {
    public int update(Group group);
    public int updateLeader(List<Integer> listLeader);
    public List<Group> loadAllGroup();
    public List<Integer> loadAllLeaderId();
    public int insertLeader(Group group);
    public Group loadByGroupLeader(int groupLeaderId);
}
