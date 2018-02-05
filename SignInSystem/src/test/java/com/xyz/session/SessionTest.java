package com.xyz.session;

import com.xyz.controller.MySessionContext;
import com.xyz.controller.SmsDemo;
import com.xyz.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest {
    public static String selectUser(HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("code", "1912505636");
       String  sessionId = request.getSession().getId();
       return  sessionId;
    }


}
