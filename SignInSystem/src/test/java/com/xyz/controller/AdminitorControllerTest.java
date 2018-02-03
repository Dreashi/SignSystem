package com.xyz.controller;

import com.xyz.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})
public class AdminitorControllerTest {
   @Autowired
    private AdminitorController adminitorContriller;
    @Test
   public void  b  (){
//        TreeMap<HashMap<Integer,User>,ArrayList<User>> a= adminitorContriller.loadAll();
//        System.out.println(a);
//   adminitorContriller.saveHandler(1234567);
//        List<Integer> list=new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(5);
//       adminitorContriller.deleteHandler(list);
   }
}
