package com.xzy.controller;

import com.shiro.realms.ShiroRealm;
import com.xzy.model.Register;
import com.xzy.model.UserPassword;
import com.xzy.service.IPasswordService;
import com.xzy.service.IUserService;
import com.xzy.service.ipml.PasswordServiceImpl;
import com.xzy.service.ipml.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private IUserService userService = new UserServiceImpl();
    @Resource
    private IPasswordService passwordService = new PasswordServiceImpl();
    @RequestMapping("/doRegister")
    @ResponseBody
    public int doRegister(HttpServletResponse response, HttpServletRequest request, Register register, String sessionId){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Boolean flag=false;
            MySessionController myc = MySessionController.getInstance();
            HttpSession sess = myc.getSession(sessionId);
            String code = sess.getAttribute("code").toString();
            //String code ="w";
            System.out.println("------------>>"+code);
            System.out.println("---------->>-------->>"+register);
            if(code!=null && code.equals(request.getParameter("userCode"))){
                System.out.println("---------->>-------->>"+register);
                flag = userService.doRegister(register);
            }
            String phone = register.getUserPhone();
            int userId = userService.selectUserId(phone);
            String string = register.getUserPassword();
            String result = ShiroRealm.MD5Encryption(string).toString();
            UserPassword userPassword = new UserPassword();
            System.out.println(phone+"-------"+userId);
            userPassword.setUserId(userId);
            userPassword.setUserPwd(result);
            System.out.println( "-----------------------------"+userPassword.getUserId()+userPassword.getUserPwd());
            //passwordService.insertPasswords(userPassword);
            if(flag){
                passwordService.insertPasswords(userPassword);
                System.out.println("注册成功");
                return 0;
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
