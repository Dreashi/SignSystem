package com.xzy.controller;

import com.xzy.service.IUserService;
import com.xzy.service.email.MyEailUtil;
import com.xzy.service.ipml.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/checkEmail")
public class CheckEmailController {
    @Resource
    private IUserService userService = new UserServiceImpl();
    @RequestMapping("/Email")
    @ResponseBody
    public int checkEmail(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        String string1 = request.getParameter("userEmail");
        String string2 = request.getParameter("userName");
        Boolean bool=false;
        try {
            MyEailUtil.sendEmail(string1,string2,"新卓越","你的邮箱正在注册账号请注意是否本人操作！");
            bool = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------->" + string1 + "___" + string1);
        int user_id1 = userService.selectRegisterEmail(string1);
        System.out.println("--------------->>>>>>>>>>" + user_id1);
        if (user_id1 == 0) {
            if(bool){
                return 0;
            }
        } else if (user_id1 != 0) {
            System.out.println("--------------------------》邮箱已经存在");
            //如果userPhone 和userEmail重复返回1
            return 1;
        }
        return 1;
    }
}
