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
@RequestMapping("/checkPhone")
public class CheckPhoneController {
    @Resource
    private IUserService userService = new UserServiceImpl();
    @RequestMapping("/Phone")
    @ResponseBody
    public int checkPhone(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        String userPhone = request.getParameter("userPhone");

        int user_id1 = userService.selectRegisterPhone(userPhone);

        Boolean flag = false;
        if (user_id1 == 0) {
            return 0;
        } else if (user_id1 != 0) {

            //如果userPhone 和userEmail重复返回1
            return 1;
        }
        return 1;
    }
}
