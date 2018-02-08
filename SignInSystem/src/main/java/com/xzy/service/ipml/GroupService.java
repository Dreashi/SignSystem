package com.xzy.service.ipml;

import com.xzy.dao.IGroupDao;
import com.xzy.model.Group;
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

    @Override
    public boolean updateGroupDirect(int groupId,String groupName,String groupDirect) {
        Group group=groupDao.selectGroupLeaderId(groupId);
        group.setGroupDirect(groupDirect);
        group.setGroupName(groupName);
        int res= groupDao.updateGroupDirect(group);
        return res>0?true:false;
    }
}
