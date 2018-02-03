package com.xyz.service.ipml;

import com.xyz.dao.AdminitorDao;
import com.xyz.dao.GroupDao;
import com.xyz.model.Group;
import com.xyz.model.User;
import com.xyz.service.IAdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("adminitorService")
public class AdminitorService implements IAdminitorService {
    @Autowired
    private AdminitorDao adminitorDao;
    @Autowired
    private GroupDao groupDao;
    @Override
    public List<User> loadAll() {
        // TODO Auto-generated method stub
        return adminitorDao.loadAll();
    }
    @Override
    public boolean loadByPhone(String userPhone) {
        boolean bool=false;
        User user = adminitorDao.loadByPhone(userPhone);
        if (user.getGroupId() == 0) {
            Group oldGroup =new Group();
            oldGroup.setGroupName("新建组");
            oldGroup.setGroupDirect("请输入组描述");
            oldGroup.setGroupLeaderId(user.getUserId());
            bool = insertLeader(oldGroup);
            if(bool==true){
                Group newgroup = groupDao.loadByGroupLeader(user.getUserId());
                bool=updateUser(newgroup);
            }else{
                bool=false;
            }
        } else {
            Integer ui = user.getUserId();
            Integer gi = user.getGroupId();
            Group g = new Group(gi, ui);
             bool = update(g);
        }
        return bool;
    }
    @Override
    public boolean insertLeader(Group newGroup){
        int count=  groupDao.insertLeader(newGroup);
        return count>0?true:false;
    }
    @Override
    public boolean updateUser(Group group){
        int count =adminitorDao.updateUser(group);
        return count>0?true:false;
    }
    @Override
    public boolean update (Group group) {
        int count=groupDao.update(group);
        return count>0?true:false;
    }
    @Override
    public boolean updateLeader(List<Integer> listLeader) {
        int count= groupDao.updateLeader(listLeader);
        return count > 0 ? true : false;
    }
    @Override
    public List<Group> loadAllGroup() {
        // TODO Auto-generated method stub
        return groupDao.loadAllGroup();
    }
    @Override
    public List<Integer> loadAllLeaderId() {

        return this.groupDao.loadAllLeaderId();
    }
}
