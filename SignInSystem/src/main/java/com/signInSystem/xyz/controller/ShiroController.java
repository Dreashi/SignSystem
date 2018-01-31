package com.signInSystem.xyz.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 版本：/shiro_3
 */
    @Controller
    @RequestMapping("/shiro")
    public class ShiroController {


        @RequestMapping("/login")
        public String login(@RequestParam("userName") String userName,@RequestParam("userPwd") String userPwd) {
            Subject currentUser = SecurityUtils.getSubject();
                //测试是否已经被认证，，，就是已经登录
            String result="redirect:/error.jsp";
                //可以不必认证，直接select数据库中是否有这个值，没有就跳到别的界面
                //把用户名和密码封装为UsernamePasswordToken对象
                UsernamePasswordToken token = new UsernamePasswordToken(userName, userPwd);
                //RememberMe
                token.setRememberMe(true);
                try {
                    //执行登录
                    currentUser.login(token);
                    result="redirect:/list.jsp";
                } catch (AuthenticationException ae) {
                    System.out.println("登录失败---------------" + ae.getMessage());
                }

            return result;
        }
}
