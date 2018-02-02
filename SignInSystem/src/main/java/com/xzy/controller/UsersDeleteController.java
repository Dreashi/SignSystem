package com.xzy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.service.IUserDelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
@Controller
@RequestMapping("/deleteHandler")
public class UsersDeleteController {
    @Resource
    IUserDelService userDelSrvice;
    @RequestMapping("/deleteUsers.do")
    @ResponseBody
    public  void   deleteUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, UnsupportedEncodingException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String[] str =request.getParameterValues("userID");
        int arr[]=new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
       boolean res=userDelSrvice.updateUsersGroupId(arr);
        ObjectMapper mapper=new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(res));
    }
}
