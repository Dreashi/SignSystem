package com.xzy.dao;

import com.xzy.model.SignIn;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.dao.DataAccessException;

import java.util.List;

public interface ISignInDao {
    //查询个人所有签到------足迹（我的历史签到）
    List<SignIn> selectById(int userId);
    //查询当天所有签到------足迹（） / 管理员点击通讯录
    List<SignIn> selectByDate(String signInDate);
    //查询当天本组所有人签到情况------足迹（今日所有签到------只显示本组）
    List<SignIn> selectByGroupIdAndDate(int userId);
    //插入一条签到信息
    int updateSignInStatusByUsers(@Param(value = "signInTime")String signInTime,@Param(value = "userId")int userId)  throws DataAccessException;
    //给管理员留一个改签到状态接口
    int updateSignInStatusByAdmin(int userId)throws DataAccessException;
}
