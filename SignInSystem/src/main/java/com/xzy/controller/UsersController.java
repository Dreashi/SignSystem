package com.xzy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/saveHandler")
public class UsersController {
    @Resource
    IUserService userService;

    @RequestMapping("/findUsers.do")
    public  void   findUsers(HttpServletRequest request,HttpServletResponse response)throws IOException,UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String userPhone = request.getParameter("userPhone");
        int groupleaderId = Integer.parseInt(request.getParameter("groupleaderId"));
        boolean res = userService.updateUsersGroupId(userPhone,groupleaderId);
//        System.out.println("\n\n\n\n\n\n\n\n"+res+"\n\n\n\n\n\n\n\n");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(res));
        response.getWriter().close();
    }

}
