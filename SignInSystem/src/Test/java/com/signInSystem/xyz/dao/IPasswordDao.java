package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.security.util.Password;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IPasswordDao {
    @Resource
    private PasswordMapper dao;
    @Test
    public void insertPassword() throws  Exception{
        /**
         * 注册的信息Register
         * 获得userpassword,再经过加盐方法加盐
         * 再通过UserPassword 的 pwd_id  INT  AUTO_INCREMENT进行自增长
         * 再通过Register的对象获得 userPhone ，通过public int selectPassword(String user_phone)throws Exception;
         * 获得user_id.
         *
         */
        UserPassword userPassword=new UserPassword();
        //加盐
        PasswordAddSalt passwordAddSalt=new PasswordAddSalt();
        String string = "sdfsdfsdsdfsdffds";
        String pwd=passwordAddSalt.getSalt(string);
        //加盐完成


        //对User_Password 进行加入数据
        userPassword.setUser_pwd(pwd);

        //第一步：获得一个Register的对象register调用register.getUserPhone()获得String 类型的user_phone;
        //第二部：调用public int selectPassword(user_phone)获得user_id
        //假设已经获得  7
        int i=7;
       userPassword.setUser_id(7);
        System.out.println("-------------------->"+pwd);
        dao.insertPasswords(userPassword);
    }
    @Test
    public void selectTrueUserPassword(){

        String str= dao.selectTrueUserPassword(2);
        System.out.println("__________________>"+str);
        //去盐
       // String [] password= str.split("~");
        //System.out.println(password[1]);
    }

}
