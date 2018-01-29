package com.xyz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.model.SignIn;
import com.xyz.service.ISignInService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

    @Controller
    @RequestMapping("/signIn")
    public class SignInController {
        @Resource
        private ISignInService signInService;

        @RequestMapping("/selectSignInById.do")
        public void selectSignById(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int userId = Integer.parseInt(request.getParameter("userId"));
            List<SignIn>list = signInService.select(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(list.toString()));
            response.getWriter().close();
        }

        @RequestMapping("/selectSignInByDate.do")
        public void selectSignInByDate(HttpServletRequest request, HttpServletResponse response) throws IOException,ParseException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
          String signInDate = request.getParameter("signInDate");
          List<SignIn>list = signInService.select(signInDate);
          ObjectMapper mapper = new ObjectMapper();
          response.getWriter().write(mapper.writeValueAsString(list.toString()));
          response.getWriter().close();
        }

        @RequestMapping("/selectSignInByIdAndDate.do")
        public void selectSignInByIdAndDate(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int userId = Integer.parseInt(request.getParameter("userId"));
            String signInDate = request.getParameter("signInDate");
            List<SignIn>list = signInService.select(signInDate,userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(list.toString()));
            response.getWriter().close();
        }

        @RequestMapping("/insertInToSignIn.do")
        public void insertInToSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            int userId = (int)request.getSession().getAttribute("userId");
            String signInTime = request.getParameter("signInTime");
            boolean bool = signInService.insert(userId,signInTime);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(bool));
            response.getWriter().close();
        }
    }
