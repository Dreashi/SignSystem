package com.signInSystem.xyz.controller;

import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IPasswordService;
import com.signInSystem.xyz.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


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
        public String login(@RequestParam("userName") String userName,@RequestParam("userPwd") String userPwd) {

        //UsernamePasswordToken token = new UsernamePasswordToken(userName, userPwd);
        //token.setRememberMe(true);
        String result=null;
        //拿到原始密码-----userPwd
        //加密，和原密码表中的数据进行比对
        String algorithmName="MD5";
        Object source=userPwd;
        Object salt= ByteSource.Util.bytes("user");
        int hashIterations=1024;

        Object afterEncryptionPwd=new SimpleHash(algorithmName, source, salt, hashIterations);
        //通过phone找id
        int userId=this.userService.selectUserId(userName);
        //通过phone找对象
        Users user=this.userService.selectUser(userName);
        // System.out.println("------------------>"+userId);
        //通过userid找密码
        //System.out.println(this.passwordService.selectUserPassword(userId));
        //此时passwords表中的密码
        String userPassword=this.passwordService.selectUserPassword(userId);
        System.out.println(afterEncryptionPwd+"---------"+userName);
        //SimpleAuthenticationInfo info=null;
        if(user!=null && afterEncryptionPwd.equals(userPassword)){
            //System.out.println(user);
            result="index";
        }else{
            result="error";
        }
//            try {
//                //执行登录
//                System.out.println("1."+token.hashCode());
//
//            }catch (AuthenticationException ae) {
//                //unexpected condition?  error?
//                System.out.println("登录失败"+ae.getMessage());
//            }
            return "0";
        }
}
