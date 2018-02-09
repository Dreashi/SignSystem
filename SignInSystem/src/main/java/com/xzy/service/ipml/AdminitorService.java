package com.xzy.service.ipml;



import com.xzy.dao.IAdminitorDao;
import com.xzy.model.Adminitor;

import com.xzy.dao.IGroupDao;
import com.xzy.model.Group;
import com.xzy.model.Users;

import com.xzy.service.IAdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminitorService")
public class AdminitorService implements IAdminitorService {
    @Autowired
    private IAdminitorDao adminitorDao;
    @Autowired
    private IGroupDao groupDao;
    @Override
    public List<Users> loadAll() {
        // TODO Auto-generated method stub
        return adminitorDao.loadAll();
    }
    @Override
    public boolean loadByPhone(String userPhone) {
        boolean bool=false;
        Users users = adminitorDao.loadByPhone(userPhone);
        if (users.getGroupId() == 0) {
            Group oldGroup =new Group();
            oldGroup.setGroupName("新建组");
            oldGroup.setGroupDirect("请输入组描述");
            oldGroup.setGroupLeaderId(users.getUserId());
            bool = insertLeader(oldGroup);
            if(bool==true){
                Group newgroup = groupDao.loadByGroupLeader(users.getUserId());
                bool=updateUser(newgroup);
            }else{
                bool=false;
            }
        } else {
            Integer ui = users.getUserId();
            Integer gi = users.getGroupId();
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
    @Override
    public List<Adminitor> loadAllAdminitor() {
        List<Adminitor> list = adminitorDao.loadAllAdminitor();
        int count = list.size();
        return count > 0 ? list : null;
    }
        public boolean loadByUserId(int userId) {
            Adminitor adminitor = adminitorDao.loadByUserId(userId);
            return adminitor!=null?true:false;
        }
}
