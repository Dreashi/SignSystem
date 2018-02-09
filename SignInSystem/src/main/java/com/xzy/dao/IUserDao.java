package com.xzy.dao;

import com.xzy.model.Register;
import com.xzy.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
  public Users loadUserPhone(String userPhone);
  public Users selectUser(String userPhone) throws Exception;
  public void insertUser(Users user)throws Exception;
  public String selectPassword(int userId)throws Exception;
  public Integer selectUserId( String userPhone)throws Exception;
  public void insertRegister(Register register);
  public int selectRegisterPhone(String userPhone);
  public int selectRegisterEmail(String useremail);
  public Users selectUserByUserId(int userId);
  public Integer selectGroupId(int groupLeaderId);
  public Integer updateGroupIdAddUsers(@Param("groupId") int groupId, @Param("userId") int userId, @Param("userName") String userName);
  public int updateGroupIdDeleteUsers(int userId[]);
  public List<Users> selectUsers(int groupId);

}
