package com.xyz.service;

import com.xyz.model.User;
import com.xyz.service.ipml.AdminitorService;
import com.xyz.service.ipml.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AdministorServiceTest {

    @Autowired
    private AdminitorService adminitorService;
   @Autowired
   private UserService userService;
    @Test
    public void UserServiceTest(){
     boolean bool=  adminitorService.loadByPhone("1912505636");
//         System.out.print(bool);
//        List<Integer> list=new ArrayList<>();
//        list.add(2);
//        list.add(4);
//        list.add(5);
//       boolean bool=  adminitorService.updateLeader(list);
//       adminitorService.loadAll();
//        User userP =     userService.loadUserPhone("123");
//        System.out.println(userP);

    }
}
