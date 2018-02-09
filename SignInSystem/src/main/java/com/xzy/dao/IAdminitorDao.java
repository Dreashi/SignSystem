package com.xzy.dao;


import com.xzy.model.Adminitor;
import com.xzy.model.Group;
import com.xzy.model.Users;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IAdminitorDao {
    public Adminitor loadByUserId(int userId);
    public List<Adminitor> loadAllAdminitor();
    public List<Users> loadAll();
    public Users loadByPhone(String userPhone);
    public int updateUser(Group group);


}
