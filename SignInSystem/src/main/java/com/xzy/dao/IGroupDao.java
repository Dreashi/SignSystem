package com.xzy.dao;

import com.xzy.entity.Group;

public interface IGroupDao {
    public Group selectGroupLeaderId(int  groupId);
}
