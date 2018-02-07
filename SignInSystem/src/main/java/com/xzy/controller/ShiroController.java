package com.xzy.controller;

import com.shiro.realms.ShiroRealm;
import com.xzy.model.Register;
import com.xzy.model.UserPassword;
import com.xzy.model.Users;
import com.xzy.service.IPasswordService;
import com.xzy.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


/**
 * 版本：/shiro_3
 */
    @Controller
    @RequestMapping("/shiro")
    public class ShiroController {

        //在此处直接把密码加密，直接进行比较

        @Resource
        private IUserService userService;

        @Resource
        private IPasswordService passwordService;


    @RequestMapping("/login")
    @ResponseBody
        public Users login(@RequestParam("userPhone") String userName, @RequestParam("userPassword") String userPwd) {

        //UsernamePasswordToken token = new UsernamePasswordToken(userName, userPwd);
        //token.setRememberMe(true);
        synchronized (this) {
            String result = null;
            //拿到原始密码-----userPwd
            //加密，和原密码表中的数据进行比对
            String algorithmName = "MD5";
            Object source = userPwd;
            Object salt = ByteSource.Util.bytes("user");
            int hashIterations = 1024;

            Object afterEncryptionPwd = new SimpleHash(algorithmName, source, salt, hashIterations);
            //通过phone找id
            int userId = this.userService.selectUserId(userName);
            //通过phone找对象
            Users user = this.userService.selectUser(userName);
            // System.out.println("------------------>"+userId);
            //通过userid找密码
            //System.out.println(this.passwordService.selectUserPassword(userId));
            //此时passwords表中的密码
            String userPassword = this.passwordService.selectUserPassword(userId);
            System.out.println(afterEncryptionPwd + "---------" + userName);
            //SimpleAuthenticationInfo info=null;
//            if (user != null && afterEncryptionPwd.equals(userPassword)) {
//                //System.out.println(user);
//                result = "index";
//            } else {
//                result = "error";
//            }
//            try {
//                //执行登录
//                System.out.println("1."+token.hashCode());
//
//            }catch (AuthenticationException ae) {
//                //unexpected condition?  error?
//                System.out.println("登录失败"+ae.getMessage());
//            }
            return user;
        }
        }
    @RequestMapping("/register")
    public String doRegister(HttpServletResponse response, HttpServletRequest request, Register register){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            System.out.println("------------------------------->"+register);
            //String string = register.getUserPassword();

            String string1  = register.getUserPhone();
            int user_id = userService.selectUserId(string1);
            System.out.println("--------------->>>>>>>>>>"+user_id);
            Boolean flag=false;
            if(user_id==0){
                flag = userService.doRegister(register);
            }else{
                System.out.println("--------------------------》用户名已经存在");
                return "error";
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
                System.out.println("注册成功");
                return "redirect:success";
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return"index.xml";
    }



}
