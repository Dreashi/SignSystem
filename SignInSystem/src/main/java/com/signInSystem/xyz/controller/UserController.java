package com.signInSystem.xyz.controller;

import javax.servlet.http.HttpServletRequest;

import com.signInSystem.xyz.model.LoginMessage;
import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @Controller
   // @RequestMapping("/user")

    public class UserController {

        @Resource
        private IUserService userService;

        @RequestMapping("/showUser.do")
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            long userId = Long.parseLong(request.getParameter("id"));
            Users user = this.userService.selectUser(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(user));
            response.getWriter().close();
        }
        @RequestMapping("/loginTest")
        public String loginTest(LoginMessage loginMessage){

            System.out.println("---------------------->"+loginMessage);
            //PasswordAddSalt passwordAddSalt=new PasswordAddSalt();
            // String pwd=passwordAddSalt.getSalt(loginMessage.getUserPwd());

            //public Users selectUser(loginMessage.getUserPwd());
            return "index";
        }

    }

