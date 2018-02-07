package com.signInSystem.xyz.dao;

import com.signInSystem.xyz.model.Register;
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
        System.out.println(user.getUser_name());
    }
    @Test
    public void insertUser()throws Exception{
        Date date = new Date();
        Register user = new Register();
        user.setUserName("王五");
      //  user.setGroup_id(1);
        user.setUserSex("男");
        user.setUserBirthday(date);
        user.setUserQQ("9763923834");
        user.setUserEmail("976392383977@qq.com");
       // user.setUser_image("sdfsdfsdffsdfsdf");
        user.setUserPhone("18392608037777");
        dao.insertUser(user);
   }

    /**
     * 通过LoginMessage 对象获得user_phone
     *
     * @return
     * @throws Exception
     */
    @Test
    public void selectPassword()throws Exception{
        //z这里测试自定一个String string = "18392608037"
        String string = "18392608037777";
        int i = dao.selectPassword(string);
        System.out.println("----------------------------------"+i);
    }

}