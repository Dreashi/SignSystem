package com.xzy.dao;

<<<<<<< HEAD
import com.xzy.model.Group;

public interface IGroupDao {
    public Group loadByGroupId(int groupId);

    public Group loadByGroupLeaderId(int groupLeaderId);

=======


import com.xzy.model.Group;

import java.util.List;

public interface IGroupDao {
    public int update(Group group);
    public int updateLeader(List<Integer> listLeader);
    public List<Group> loadAllGroup();
    public List<Integer> loadAllLeaderId();
    public int insertLeader(Group group);
    public Group loadByGroupLeader(int groupLeaderId);
>>>>>>> GHH
}
