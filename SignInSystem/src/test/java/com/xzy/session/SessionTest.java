package com.xzy.session;

import javax.servlet.http.HttpServletRequest;

public class SessionTest {
    public static String selectUser(HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("code", "1912505636");
       String  sessionId = request.getSession().getId();
       return  sessionId;
    }


}
