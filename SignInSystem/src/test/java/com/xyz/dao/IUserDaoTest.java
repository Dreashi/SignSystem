package com.xyz.dao;

import com.xyz.controller.AdminitorController;
import com.xyz.model.User;
import com.xyz.service.ipml.AdminitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    private AdminitorController adminitorController;
    @Resource
    private GroupDao groupDao;
    @Test
    public void testloadUser() throws Exception {
      User user=  adminitorDao.loadByPhone("18709295515");
       System.out.println(user);
//      List<User> list= adminitorDao.loadAll();
//        for (User u : list) {
//         System.out.println(u);
//        }
//        List<Integer> l=new ArrayList<>();
//        l.add(1);
//        l.add(6);
//        List<Group> g=adminitorDao.loadByLeaderId(l);
//        for (Group gr : g) {
//            System.out.println(gr);
//        }
//       User bool =adminitorDao.loadByPhone("18709295515");
//        System.out.println(bool);





//             List<Group> list= groupDao.loadAll();
//                    for (Group u : list) {
//                System.out.println(u);
//        }
//        List<Integer> list= groupDao.loadAllLeaderId();
//
//            System.out.println(list);
     //   groupDao.updateGroup(5);
        }
    }

