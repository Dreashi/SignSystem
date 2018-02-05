package com.signInSystem.xyz.service;

import com.signInSystem.xyz.model.Register;
import com.signInSystem.xyz.model.Users;

public interface IUserService {
    public Users selectUser(String user_phone);
    public void insertUser(Users user);
    public int selectUserId(String user_phone);
    public boolean doRegister(Register register);
    public void insertRegister(Register register);
    public int selectRegisterId(Register register);
    public int selectRegisterEmail(Register register);

}
