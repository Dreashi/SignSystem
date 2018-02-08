package com.xzy.service;

import com.xzy.model.Group;

public interface IGroupService {
    public Group selectGroupLeaderId(int groupId);
    public boolean updateGroupDirect(int groupId, String groupName, String groupDirect);
}
