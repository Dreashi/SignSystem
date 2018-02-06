package com.xzy.controller;

import com.shiro.realms.ShiroRealm;
import com.xzy.model.Register;
import com.xzy.model.UserPassword;
import com.xzy.service.IPasswordService;
import com.xzy.service.IUserService;
import com.xzy.service.ipml.PasswordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class RegisterController {
    @Resource
    IUserService userService ;
    @Resource
    IPasswordService passwordService = new PasswordServiceImpl();
    @RequestMapping("/registerTest")
    @ResponseBody
    public String doRegister(HttpServletResponse response, HttpServletRequest request, Register register){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            System.out.println("------------------------------->"+register);
            String string1 = register.getUserPhone();
            //已经获取到了email，判断，进行比对
            String string2=register.getUserEmail();

            int user_id1=userService.selectRegisterEmail(register);

            int user_id = userService.selectUserId(string1);
            System.out.println("--------------->>>>>>>>>>"+user_id);
            Boolean flag=false;
            if(user_id==0){
                flag = userService.doRegister(register);
            }else if (user_id!=0 || user_id1!=0){
                System.out.println("--------------------------》电话号或邮箱已经存在");
                //如果userPhone 和userEmail重复返回1
                return "1";
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
            passwordService.insertPasswords(userPassword);

            if(flag){
               // System.out.println("注册成功");
                return "0";
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
