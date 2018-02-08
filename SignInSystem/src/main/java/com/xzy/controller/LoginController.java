package com.xzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/loginContro")
public class LoginController {

    @RequestMapping("/returnindex")
    public String returnIndex(HttpServletRequest request , HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.getSession().setAttribute("userId",6);


        return "index";
    }

}
