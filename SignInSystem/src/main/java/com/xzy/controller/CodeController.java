package com.xzy.controller;

import com.xzy.model.Users;
import com.xzy.service.code.SmsDemo;
import com.xzy.service.ipml.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *   CodeController
 *
 * @author poison
 * @date 2018/2/7
 */
@Controller
    @RequestMapping("/userCode")
    public class CodeController {
        @Autowired
        private UserServiceImpl userService;
        Logger logger = LoggerFactory.getLogger(CodeController.class);
        @RequestMapping("/showUser.do")
        @ResponseBody
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String sessionId=null;
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String phone=request.getParameter("userPhone");
            Users usersP =  userService.loadUserPhone(phone);
            Map<String ,Object> pmap=new HashMap<>();
            if(usersP !=null){
                String  number= SmsDemo.createRandomNum(6);
                request.getSession().setAttribute("code", number);
                sessionId = request.getSession().getId();
                pmap.put("sessionId",sessionId);
                pmap.put("userId", usersP.getUserId());
            try {
                SmsDemo.sendSms(phone,number);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}else{
                pmap.put("err",0);
            }
            JsonpController.jsonP(request,response,pmap);
        }
    @RequestMapping("/checkCode")
    @ResponseBody
    public void checkCode(HttpServletRequest request, HttpServletResponse response, String number, String sessionId) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String ,Integer> pmap=new HashMap<>();
        MySessionController myc= MySessionController.getInstance();
        HttpSession sess = myc.getSession(sessionId);
        String  code=(String)sess.getAttribute("code");
        if(code!=null){
            if(code.equals(number)) {
                pmap.put("suc",1);
            }else{
                pmap.put("err",0);
            }
        }else{
            pmap.put("suc",0);
        }
     JsonpController.jsonP(request,response,pmap);
    }
    }

