package com.xzy.dao;


import com.xzy.model.Group;
import java.util.List;

public interface IGroupDao {
    public Group loadByGroupId(int groupId);

    public Group loadByGroupLeaderId(int groupLeaderId);

    public int update(Group group);

    public int updateLeader(List<Integer> listLeader);

    public List<Group> loadAllGroup();

    public List<Integer> loadAllLeaderId();

    public int insertLeader(Group group);

    public Group loadByGroupLeader(int groupLeaderId);

    public Group selectGroupLeaderId(int groupId);

    public int updateGroupDirect(Group group);
}



