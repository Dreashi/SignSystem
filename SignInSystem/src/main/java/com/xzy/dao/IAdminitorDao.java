package com.xzy.dao;

<<<<<<< HEAD
import com.xzy.model.Adminitor;

import java.util.List;

public interface IAdminitorDao {
    public Adminitor loadByUserId(int userId);
    public List<Adminitor> loadAllAdminitor();
=======
import com.xzy.model.Group;
import com.xzy.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminitorDao {
    public List<Users> loadAll();
    public Users loadByPhone(String userPhone);
     public int updateUser(Group group);
>>>>>>> GHH
}
