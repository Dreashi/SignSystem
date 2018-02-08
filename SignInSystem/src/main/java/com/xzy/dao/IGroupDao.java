package com.xzy.dao;

import com.xzy.model.Group;

public interface IGroupDao {
    public Group loadByGroupId(int groupId);

    public Group loadByGroupLeaderId(int groupLeaderId);

}
