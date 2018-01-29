package com.xyz.dao;

import com.xyz.model.SignIn;
import com.xyz.model.User;
import com.xyz.service.ISignInService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Resource
    private ISignInService service;

    @Test
    public void testSelectSignIn() throws Exception {
        int userId = 1;
//        List<SignIn>lists = service.select(userId);
//        System.out.print("\n--------------------------------------\n"+lists+"\n-----------------------------------\n");
//
//        String signInDate = "2018-01-27";
//        List<SignIn>lists2 = service.select(signInDate);
//        System.out.print("\n--------------------------------------\n"+lists2+"\n-----------------------------------\n");
//
//        List<SignIn>lists3 = service.select(signInDate,userId);
//        System.out.print("\n--------------------------------------\n"+lists3+"\n-----------------------------------\n")

        String signInTime = "08:56:11";
        System.out.print(service.insert(userId,signInTime));
    }

}