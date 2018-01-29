package com.xyz.service.ipml;

import com.xyz.dao.IGroupDao;
import com.xyz.model.Group;
import com.xyz.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("groupService")
public class GroupService implements IGroupService{
    @Resource
    private IGroupDao groupDao;
    @Override
    public List<Group> loadAll() {
        // TODO Auto-generated method stub
        return groupDao.loadAll();
    }

    @Override
    public List<Integer> loadAllLeaderId() {
        return this.groupDao.loadAllLeaderId();
    }

}
