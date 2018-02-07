package com.xzy.controller;

import com.xzy.service.IUserService;
import com.xzy.service.ipml.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class CheckPhoneController {
    @Resource
    private IUserService userService = new UserServiceImpl();
    @RequestMapping("/checkPhone")
    @ResponseBody
    public int checkEmailAndPhone(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        String string1 = request.getParameter("userPhone");
        System.out.println("---------------------------------->" + string1 + "___" + string1);
        int user_id1 = userService.selectRegisterEmail(string1);
        System.out.println("--------------->>>>>>>>>>" + user_id1);
        Boolean flag = false;
        if (user_id1 == 0) {
            return 0;
        } else if (user_id1 != 0) {
            System.out.println("--------------------------》手机号已经存在");
            //如果userPhone 和userEmail重复返回1
            return 1;
        }
        return 1;
    }
}
