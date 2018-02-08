package com.xzy.service.ipml;


import com.xzy.dao.IAdminitorDao;
import com.xzy.model.Adminitor;
import com.xzy.service.IAdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminitorService implements IAdminitorService {
    @Autowired
    private IAdminitorDao adminitorDao;
    @Override
    public boolean loadByUserId(int userId) {
        Adminitor adminitor = adminitorDao.loadByUserId(userId);
        return adminitor!=null?true:false;
    }

    @Override
    public List<Adminitor> loadAllAdminitor() {
        List<Adminitor> list = adminitorDao.loadAllAdminitor();
        int count = list.size();
        return count>0?list:null;
    }
}
