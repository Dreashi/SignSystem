package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.Register;
import com.signInSystem.xyz.model.Users;

public interface UserMapper {

  public Users selectUser(long id) throws Exception;
  public void insertUser(Register user)throws Exception;
  public int selectPassword(String user_phone)throws Exception;

}
