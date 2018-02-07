package com.xzy.controller;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MySessionController {
    private static MySessionController instance;
    private HashMap mymap;

    private MySessionController() {
        mymap = new HashMap();
    }

    public static MySessionController getInstance() {
        if (instance == null) {
            instance = new MySessionController();
        }
        return instance;
    }

    public synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String session_id) {
        if (session_id == null) {
            return null;
        }
        return (HttpSession) mymap.get(session_id);
    }
}
