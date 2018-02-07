package com.xzy.controller;

import com.xzy.model.LoginMessage;
import com.xzy.model.Users;
import com.xzy.service.IPasswordService;
import com.xzy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")

    public class UserController {

        @Resource
        private IUserService userService;

        @Resource
        private IPasswordService passwordService;
//        @RequestMapping("/showUser.do")
//        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            request.setCharacterEncoding("UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            long userId = Long.parseLong(request.getParameter("id"));
//            Users user = this.userService.selectUser(userId);
//            ObjectMapper mapper = new ObjectMapper();
//            response.getWriter().write(mapper.writeValueAsString(user));
//            response.getWriter().close();
//        }
        @RequestMapping("/loginTest")
        public String loginTest(LoginMessage loginMessage){

            String result=null;
            System.out.println("---------------------->"+loginMessage);
            //PasswordAddSalt passwordAddSalt=new PasswordAddSalt();
            // String pwd=passwordAddSalt.getSalt(loginMessage.getUserPwd());
            String userPhone=loginMessage.getUserPhone();
            String userPwd=loginMessage.getUserPwd();

            Users user=this.userService.selectUser(userPhone);


           // System.out.println("----------------->"+user);

            int userId=this.userService.selectUserId(userPhone);

           // System.out.println("------------------>"+userId);
            //通过userid找密码
            System.out.println(this.passwordService.selectUserPassword(userId));
            String userPassword=this.passwordService.selectUserPassword(userId);
            System.out.println(userPassword+"---------"+userPwd);
            if(user!=null && userPassword.equals(userPwd)){
                //System.out.println(user);
                result="index";
            }else{
                result="error";
            }
            //public Users selectUser(loginMessage.getUserPwd());
            return result;
        }

    }

