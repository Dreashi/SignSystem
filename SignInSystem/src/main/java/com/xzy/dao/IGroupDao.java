package com.xzy.dao;

import com.xzy.model.Group;

public interface IGroupDao {
    public Group loadByGroupId(int groupId);
    public Group loadByGroupLeaderId(int groupLeaderId);


    public Group selectGroupLeaderId(int  groupId);
    public int updateGroupDirect(Group group);


}
