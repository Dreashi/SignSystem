package com.xyz.controller;

import javax.servlet.http.HttpServletRequest;

import com.xyz.dao.UserDao;
import com.xyz.model.User;
import com.xyz.service.ipml.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@Controller
    @RequestMapping("/user")
    public class CodeController {
        @Autowired
        private UserService userService;
        Logger logger = LoggerFactory.getLogger(CodeController.class);
        @RequestMapping("/showUser.do")
        @ResponseBody
        public Map selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String sessionId=null;
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String phone=request.getParameter("userPhone");
            User userP=  userService.loadUserPhone(phone);
            Map<String ,String> pmap=new HashMap<>();
            if(userP!=null){
                String  number= SmsDemo.createRandomNum(6);
                request.getSession().setAttribute("code", number);
                sessionId = request.getSession().getId();
                pmap.put("sessionId",sessionId);
            try {
              SmsDemo.sendSms(phone,number);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}else{
                pmap.put("error","0");
            }
            return  pmap;
        }
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(HttpServletRequest request, String number,String sessionId) {
        boolean bool=false;
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession sess = myc.getSession(sessionId);
        String  code=(String)sess.getAttribute("code");
        if(code!=null){
            if(code.equals(number)) {
                bool = true;
            }
        }
        return bool?"1":"0";
    }
    }

