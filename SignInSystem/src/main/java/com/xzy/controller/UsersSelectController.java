package com.xzy.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.xzy.entity.User;
import com.xzy.service.IUserDelService;
import com.xzy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
@Controller
@RequestMapping("/seleteHandler")
public class UsersSelectController{
    @Resource
    IUserService userService;
    @RequestMapping("/selectUsers.do")
    @ResponseBody
    public List selectUsers(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        int groupId = Integer.parseInt(request.getParameter("groupID"));
        List userList=userService.selectUsers(groupId);
        for (Object s:userList) {
            System.out.println(s);
        }
        return userList;
    }
}


