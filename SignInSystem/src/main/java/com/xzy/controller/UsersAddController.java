package com.xzy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/saveHandler")
public class UsersAddController {
    @Resource
    IUserService userService;
    @RequestMapping("/findUsers.do")
    @ResponseBody
    public  void   selectAddUsers(HttpServletRequest request,HttpServletResponse response)throws IOException,UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String userPhone = request.getParameter("userPhone");
        int groupleaderId = Integer.parseInt(request.getParameter("groupleaderId"));
        boolean res = userService.updateUsersGroupId(userPhone,groupleaderId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(res));
        response.getWriter().close();
    }

}
