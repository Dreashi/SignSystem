package com.xyz.dao;

import com.xyz.model.User;
import com.xyz.service.ipml.AdminitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Resource
    private AdminitorDao adminitorDao;
    private AdminitorService  adminitorService1;
    @Test
    public void testloadUser() throws Exception {
       User user=  adminitorDao.loadByPhone("18709295515");
       System.out.println(user);
//       if(bool==true){
//           System.out.print("周瑜");
//       }
    }

}