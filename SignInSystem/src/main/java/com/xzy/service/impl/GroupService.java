package com.xzy.service.impl;

import com.xzy.dao.IGroupDao;
import com.xzy.entity.Group;
import com.xzy.service.IGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("IGroupService")
public class GroupService implements IGroupService {
@Resource
    IGroupDao groupDao;
    @Override
    public Group selectGroupLeaderId(int groupId) {
        return groupDao.selectGroupLeaderId(groupId);
    }
}
