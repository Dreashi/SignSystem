package com.xzy.service;

import com.xzy.model.Register;
import com.xzy.model.Users;

import java.util.List;

public interface IUserService {
    public Users selectUser(String user_phone);
    public void insertUser(Users user);
    public Integer selectUserId(String user_phone);
    public boolean doRegister(Register register);
    public void insertRegister(Register register);
    public int selectRegisterPhone(String userPhone);
    public int selectRegisterEmail(String userEmail);

    public Users selectUserByUserId(int userId);

    public Users loadUserPhone(String userPhone);


    public boolean updateUsersGroupId(String userPhone,int groupLeaderId,String userName) throws Exception;
    public List<Users> selectUsers(int groupId);
    public boolean updateUsersGroupId(int userId[]);

}
