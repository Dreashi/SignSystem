package com.xzy.controller;

import javax.servlet.http.HttpServletRequest;

import com.xzy.model.User;
import com.xzy.service.ipml.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        private UserService userService;
        Logger logger = LoggerFactory.getLogger(CodeController.class);
        @RequestMapping("/showUser.do")
        @ResponseBody
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String sessionId=null;
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String phone=request.getParameter("userPhone");
            User userP =  userService.loadUserPhone(phone);
            Map<String ,Object> pmap=new HashMap<>();
            if(userP !=null){
                String  number= SmsDemo.createRandomNum(6);
                request.getSession().setAttribute("code", number);
                sessionId = request.getSession().getId();
                pmap.put("sessionId",sessionId);
                pmap.put("userId", userP.getUserId());
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
    public void checkCode(HttpServletRequest request,HttpServletResponse response, String number,String sessionId) {
        Map<String ,Integer> pmap=new HashMap<>();
        MySessionContext myc= MySessionContext.getInstance();
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

