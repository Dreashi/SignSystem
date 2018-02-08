package com.xzy.controller;

import com.xzy.service.code.SmsDemo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/getCode")
public class GetCodeController {

    @RequestMapping("/Code")
    @ResponseBody
    public Map getCode(HttpServletRequest request, HttpServletResponse response){

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding("UTF-8");
        Boolean bool=false;
        Map<String ,String> pamp = new HashMap();
        String number = SmsDemo.createRandomNum(6);
        HttpSession session = request.getSession();

        String phone = request.getParameter("userPhone");
        System.out.println("----------------->"+phone);
        if(session!=null){
            session.setAttribute("code",number);
            String sessionId = request.getSession().getId();
            pamp.put("sessionId",sessionId);
            try {
                SmsDemo.sendSms(phone,number);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else{
            pamp.put("error","0");
        }
        return pamp;
    }
}
