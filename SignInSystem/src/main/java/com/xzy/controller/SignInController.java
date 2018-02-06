package com.xzy.controller;

import com.xzy.model.SignIn;
import com.xzy.service.ISignInService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @Controller
    @RequestMapping("/signIn")
    public class SignInController {
        @Resource
        private ISignInService signInService;

        @RequestMapping("/selectSignInById.do")
        @ResponseBody
        public List<SignIn> selectSignById(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
//            int userId = Integer.parseInt(request.getParameter("userId"));
            int userId = 1;
            List<SignIn>list = signInService.select(userId);
            return list;

        }

        @RequestMapping("/selectSignInByDate.do")
        @ResponseBody
        public List<SignIn> selectSignInByDate(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String signInDate = request.getParameter("signInDate");
            List<SignIn>list = signInService.select(signInDate);
            return list;
        }

        @RequestMapping("/selectSignInByGroupIdAndDate.do")
        @ResponseBody
        public List<SignIn> selectSignInByIdAndDate(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
//            int userId = (int)request.getSession().getAttribute("userId");
            int userId = 1;
            List<SignIn>list = signInService.selectByGroupId(userId);
            return list;
        }

        //签到插入新的元组
        @RequestMapping("/updateSignInStatusByUser.do")
        @ResponseBody
        public String updateSignInStatusByAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8"); 
            //获取前端传递的参数
//            int userId = (int)request.getSession().getAttribute("userId");
            int userId = 5;
            String signInTime = request.getParameter("signInTime");
            boolean bool = false;
            bool = signInService.update(signInTime,userId);
            return bool?"签到成功":"签到失败";
        }


        //管理员改变签到状态
        @RequestMapping("/updateSignInStatusByAdmin.do")
        @ResponseBody
        public String updateSignInStatus(HttpServletRequest request , HttpServletResponse response) throws IOException{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            int userId = (int)request.getSession().getAttribute("userId");

            boolean bool = false;
            bool = signInService.update(userId);
            return bool?"更改成功":"更改失败";
        }
    }
