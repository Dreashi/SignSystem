package com.xzy;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.xzy.entity.User;
import com.xzy.service.IUserDelService;
import com.xzy.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class test  {
//    @Resource
//    private IUserDelService userdelservice;
//    @Resource
//    private IUserService userService;
//    @Test
//    public  void test(){
//        String userPhone = "18292382110";
//        int groupleaderId = 4;
//        System.out.println(userService.updateUsersGroupId(userPhone,groupleaderId));
//    }
//     @Test
//    public void test(){
//         int arr[]={1,2};
//         System.out.println(userdelservice.updateUsersGroupId(arr));
//     }
    @Resource
    private IUserService userService;
    @Test
    public void test(){
        List<User> arr=userService.selectUsers(1);
        for (User o:arr) {
            System.out.println(o);
        }
    }
}
