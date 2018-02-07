package com.xzy.service;

import com.xzy.model.Register;
import com.xzy.model.Users;

public interface IUserService {
    public Users selectUser(String user_phone);
    public void insertUser(Users user);
    public int selectUserId(String user_phone);
    public boolean doRegister(Register register);
    public void insertRegister(Register register);
    public int selectRegisterId(Register register);
    public int selectRegisterEmail(String useremail);

}
