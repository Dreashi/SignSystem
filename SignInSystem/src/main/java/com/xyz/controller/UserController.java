package com.xyz.controller;

import javax.servlet.http.HttpServletRequest;

import com.xyz.model.User;
import com.xyz.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @Controller
    @RequestMapping("/user")
    public class UserController {

        Logger logger = LoggerFactory.getLogger(UserController.class);

        @Resource
        private IUserService userService;

        @RequestMapping("/showUser.do")
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            long userId = Long.parseLong(request.getParameter("id"));
            User user = this.userService.selectUser(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(user));
            response.getWriter().close();
        }

    }

