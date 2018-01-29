package com.xyz.controller;

import javax.servlet.http.HttpServletRequest;

import com.xyz.model.User;
import com.xyz.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @Controller
    @RequestMapping("/user")
    public class UserController {
        @Resource
        private IUserService userService;

        @RequestMapping("/showUser.do")
        public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = this.userService.selectById(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(user.toString()));
            response.getWriter().close();
        }
    }

