package com.xzy.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzy.service.IGroupService;
import com.xzy.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
@Controller
@RequestMapping("/saveHandler")
public class groupLeaderController {
        @Resource
        IUserService userService;
        @Resource
        IGroupService groupService;
        @RequestMapping("/findUsers.do")
        @ResponseBody
        //添加组员
        public  boolean  selectAddUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("utf-8");
            String userName=request.getParameter("userName");
            String userPhone = request.getParameter("userPhone");
            int groupLeaderId = Integer.parseInt(request.getParameter("groupleaderId"));
            boolean res = userService.updateUsersGroupId(userPhone,groupLeaderId,userName);
            return res;
        }
        //删除组员
        @RequestMapping("/deleteUsers.do")
        @ResponseBody
        public  void   deleteUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, UnsupportedEncodingException, UnsupportedEncodingException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("utf-8");
            String str =request.getParameter("userId");
            String []strArr = str.split(",");
            int arr[]=new int[strArr.length];
            for(int i=0;i<strArr.length;i++){
                arr[i]=Integer.parseInt(strArr[i]);
            }
            boolean res=userService.updateUsersGroupId(arr);
            ObjectMapper mapper=new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(res));
        }
        //查询
        @RequestMapping("/selectUsers.do")
        @ResponseBody
        public List selectUsers(HttpServletRequest request, HttpServletResponse response)  {
            response.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("utf-8");
            int groupId = Integer.parseInt(request.getParameter("groupId"));
            List userList=userService.selectUsers(groupId);
            for (Object s:userList) {
                System.out.println(s);
            }
            return userList;
        }
        //修改
        @RequestMapping("/updateUsers.do")
        @ResponseBody
        public void updateGroupDirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("utf-8");
            int groupId = Integer.parseInt(request.getParameter("groupId"));
            String groupName = request.getParameter("groupName");
            String groupDirect = request.getParameter("groupDirect");
            boolean res = groupService.updateGroupDirect(groupId, groupName,groupDirect);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(res));
        }
    }


