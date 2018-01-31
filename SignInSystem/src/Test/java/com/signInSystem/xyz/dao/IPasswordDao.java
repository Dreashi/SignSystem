package com.signInSystem.xyz.dao;


import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IPasswordDao {
    @Resource
    private PasswordMapper dao;
    @Test
    public void insertPassword() throws  Exception{
        Date date = new Date();
        Users user = new Users();
        user.setUser_id(1);
        user.setGroup_id(1);
        user.setUser_id(3);
        user.setUser_birthday(date);
        user.setUser_name("张三");
        user.setUser_phone("sdfsfsdf");
        user.setUser_qq("234234234");
        user.setUser_image("sdfsdfsdffsdfsdf");
        user.setUser_email("sdfsdfs");
        user.setUser_sex("男");
        UserPassword userPassword=new UserPassword();

        String string = "sdfsdfsdsdfsdffds";
        String pwd="aaa";
        userPassword.setUser_pwd(pwd);
        userPassword.setUser_id((int)user.getUser_id());
        System.out.println("-------------------->"+pwd);
        dao.insertPasswords(userPassword);
    }
    @Test
    public void selectUserPassword(){
       String str= dao.selectUserPassword(1);
        System.out.println("---------------->"+str);


        //去盐
       String [] password= str.split("~");
        System.out.println(password[1]);
    }

}
