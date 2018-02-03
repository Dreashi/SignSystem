package com.xyz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Controller
public class CheckNumber {
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(HttpServletRequest request, String phone, String userPwd) {
        boolean bool=false;
        String code=(String) request.getSession().getAttribute("code");
        if(code!=null){
            if(code.equals(phone)) {
                bool = true;
            }
        }
        return bool?"redirect:loadAll":"redirect:error.view";
    }
}



  


