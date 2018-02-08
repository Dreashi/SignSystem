package com.xzy.dao;

import com.xzy.model.Register;
import com.xzy.model.Users;

public interface IUserDao {
  public Users loadUserPhone(String userPhone);
  public Users selectUser(String userPhone) throws Exception;
  public void insertUser(Users user)throws Exception;
  public String selectPassword(int userId)throws Exception;
  public int selectUserId(String userPhone)throws Exception;
  public void insertRegister(Register register);
  public int selectRegisterPhone(String userPhone);
  public int selectRegisterEmail(String useremail);
<<<<<<< HEAD
  public Users selectUserByUserId(int userId);
=======

>>>>>>> GHH
}
