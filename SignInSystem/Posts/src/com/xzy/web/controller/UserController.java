package com.xzy.web.controller;

import com.xzy.business.IUserService;
import com.xzy.web.entity.User;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/loginHandler")
    public String loginHandler(HttpServletRequest req, HttpSession session){
    	User loginUser=userService.loadUserById(Integer.parseInt(req.getParameter("userId")));
        session.setAttribute("loginUser",loginUser);
        return "sendPost";
    }
}
