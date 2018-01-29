package com.xzy;

import com.xzy.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class test  {
    @Resource
    private IUserService userService;

    @Test
    public  void test(){
        String userPhone = "18292382110";
        int groupleaderId = 4;
        System.out.println(userService.updateUsersGroupId(userPhone,groupleaderId));
    }


}
