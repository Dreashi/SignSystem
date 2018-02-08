package com.xzy.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SessionListener implements HttpSessionListener {
    public static Map userMap = new HashMap();
    private  MySessionController myc=MySessionController.getInstance();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent)
    {
        myc.AddSession(httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        myc.DelSession(session);
    }
}
