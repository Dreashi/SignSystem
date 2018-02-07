package com.xzy.controller;

import javax.servlet.http.HttpServletRequest;

import com.xzy.model.User;
import com.xzy.service.ipml.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
/**
 *   CodeController
 *
 * @author poison
 * @date 2018/2/7
 */
@Controller
    @RequestMapping("/user")
    public class CodeController {
        @Autowired
        private UserService userService;
        Logger logger = LoggerFactory.getLogger(CodeController.class);
        @RequestMapping("/showUser.do")
        @ResponseBody
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String sessionId=null;
            logger.info("controller selectUser()");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String phone=request.getParameter("userPhone");
            User userP=  userService.loadUserPhone(phone);
            Map<String ,Object> pmap=new HashMap<>();
            if(userP!=null){
                String  number= SmsDemo.createRandomNum(6);
                request.getSession().setAttribute("code", number);
                sessionId = request.getSession().getId();
                pmap.put("sessionId",sessionId);
                pmap.put("userId", userP.getUserId());
            try {
                SmsDemo.sendSms(phone,number);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}else{
                pmap.put("error","0");
            }
            jsonP(request,response,pmap);
        }
    @RequestMapping("/checkCode")
    @ResponseBody
    public void checkCode(HttpServletRequest request,HttpServletResponse response, String number,String sessionId) {
        Map<String ,String> pmap=new HashMap<>();
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession sess = myc.getSession(sessionId);
        String  code=(String)sess.getAttribute("code");
        if(code!=null){
            if(code.equals(number)) {
                pmap.put("true","1");
            }else{
                pmap.put("error","0");
            }
        }else{
            pmap.put("error","0");
        }
        jsonP(request,response,pmap);
    }

    public void jsonP(HttpServletRequest request,HttpServletResponse response,Map pmap){

        try {
            response.setContentType("text/plain");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            PrintWriter out = response.getWriter();
            //根据需要拼装json
            JSONObject resultJSON = JSONObject.fromObject(pmap);
            //客户端请求参数
            String jsonpCallback = request.getParameter("jsonpCallback");
            //返回jsonp格式数据
            out.println(jsonpCallback+"("+resultJSON.toString(1,1)+")");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

