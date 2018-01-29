package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Resource
    private UserMapper dao;



    @Test
    public void testSelectUser() throws Exception {
        long user_id = 1;
        Users user = dao.selectUser(user_id);
        System.out.println("----------------------->"+user.getUser_name());
    }
    @Test
    public void insertUser()throws Exception{
        Date date = new Date();
        Users user = new Users();
        user.setGroup_id(1);
        user.setUser_birthday(date);
        user.setUser_name("张三");
        user.setUser_phone("sdfsfsdf");
        user.setUser_qq("234234234");
        user.setUser_image("sdfsdfsdffsdfsdf");
        user.setUser_email("sdfsdfs");
        user.setUser_sex("男");
        dao.insertUser(user);
   }


}