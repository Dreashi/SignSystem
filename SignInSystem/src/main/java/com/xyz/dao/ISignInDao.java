package com.xyz.dao;

import com.xyz.model.SignIn;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ISignInDao {
    //查询个人所有签到
    List<SignIn> selectById(int userId);
    //查询当天所有签到
    List<SignIn> selectByDate(String signDate);
    //查询当天本组所有人签到情况
    List<SignIn> selectByGroupIdAndDate(@Param(value = "signInDate") String signDate, @Param(value = "userId") int userId);
    //插入一条签到信息
    int insertInToSignIn(@Param(value = "userId")int userId,@Param(value = "signInTime") String signInTime);
//    //给管理员留一个改签到状态接口
//    int updateSignInStatus(int userId,Date signDate);
}
