package com.xzy.dao;

import com.xzy.model.Register;
import com.xzy.model.Users;

public interface IUserDao {

  public Users selectUser(String userPhone) throws Exception;
  public void insertUser(Users user)throws Exception;
  public String selectPassword(int userId)throws Exception;
  public int selectUserId(String userPhone)throws Exception;
  public void insertRegister(Register register);
  public int selectRegisterId(Register register);
  public int selectRegisterEmail(String useremail);
}
