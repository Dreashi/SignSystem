package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.Register;
import com.signInSystem.xyz.model.Users;

public interface UserMapper {

  public Users selectUser(String user_phone) throws Exception;
  public void insertUser(Users user)throws Exception;
  public String selectPassword(int user_id)throws Exception;
  public int selectUserId (String user_phone)throws Exception;
  public void insertRegister(Register register);
  public int selectRegisterId(Register register);
  public int selectRegisterEmail(Register register);
}
