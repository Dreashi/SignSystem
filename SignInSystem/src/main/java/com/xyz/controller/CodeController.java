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

@Controller
    @RequestMapping("/user")
    public class CodeController {
        @Autowired
        private UserService userService;
        Logger logger = LoggerFactory.getLogger(CodeController.class);
        @RequestMapping("/showUser.do")
        @ResponseBody
        public String selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
            boolean bool=false;
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String phone=request.getParameter("userPhone");
            User userP=  userService.loadUserPhone(phone);
            if(userP!=null){
            String  number= SmsDemo.createRandomNum(6);
            HttpSession session = request.getSession();
            if(session!=null) {
                session.setAttribute("code", number);
            }
            try {
                SmsDemo.sendSms(phone,number);
                bool=true;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}else{
              bool=false;
            }
            return bool?"1":"0";
        }
    }

