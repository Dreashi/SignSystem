package com.xyz.service.ipml;

import com.xyz.dao.AdminitorDao;
import com.xyz.model.Group;
import com.xyz.model.User;
import com.xyz.service.IAdminitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("AdminitorService")
public class AdminitorService implements IAdminitorService {
    @Resource
    private AdminitorDao adminitorDao;
    @Override
    public List<User> loadAll() {
        // TODO Auto-generated method stub
        return adminitorDao.loadAll();
    }


   @Override
   public boolean loadByPhone(String userPhone) {
        User user=adminitorDao.loadByPhone(userPhone);
        boolean bool=update(user);
        return bool;
    }

    @Override
    public boolean loadByLeaderId(String groupLeaderId) {
        Group group =adminitorDao.loadByLeaderId(groupLeaderId);
      boolean  bool =updateLeader(group);
        return bool;
    }


    @Override
    public boolean delete(User user) {
        int count=adminitorDao.delete(user);
        return count>0?true:false;
    }
    @Override
    public boolean updateLeader(Group group) {
        int count = adminitorDao.updateLeader(group);
        return count > 0 ? true : false;
    }
   @Override
    public boolean update (User user) {
        int count=adminitorDao.update(user);
        return count>0?true:false;
    }
}
