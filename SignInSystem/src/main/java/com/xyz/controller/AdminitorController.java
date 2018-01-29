package com.xyz.controller;

import java.lang.reflect.Array;
import java.util.*;

import com.xyz.model.Group;
import com.xyz.model.User;
import com.xyz.service.IGroupService;
import com.xyz.service.IUserService;
import com.xyz.service.ipml.AdminitorService;
import com.xyz.service.ipml.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names= {"userList","leaderList"})
public class AdminitorController {
		@Autowired
		private AdminitorService adminitorService;
		private IGroupService groupService;
		@RequestMapping("/loadAll")
		public String loadAll(Model model) {
			List<User> userList=adminitorService.loadAll();
            List<Group> groupList=groupService.loadAll();
            Map<User,ArrayList<User>> loadAllMap = new HashMap<>();
            //外层循环遍历所有组长
            for(int i = 0 ; i < groupList.size() ; i++ ) {
                int leaderId = groupList.get(i).getGroupLeaderId();
                int gropuId = groupList.get(i).getGroupId();
                ArrayList<User> tempList = new ArrayList<>();
                //找到改组所有成员信息
                for (int j = 0; j < userList.size(); ) {
                    if (userList.get(i).getGroupId() == gropuId) {
                        tempList.add(userList.get(i));
                        userList.remove(i);
                    } else {
                        j++;
                    }
                }
                //区分组长和组员并放入map
                User groupLeader = null;
                for (int j = 0; j < tempList.size(); j++) {
                    if (tempList.get(j).getUserId() == leaderId) {
                        groupLeader = tempList.get(j);
                        tempList.remove(j);
                    } else {
                        j++;
                    }
                }
                //放入map集合
                loadAllMap.put(groupLeader, tempList);
            }
            model.addAttribute("userList", loadAllMap);
            Set<User> leaderSet = loadAllMap.keySet();
            model.addAttribute("leaderList", leaderSet);
            System.out.print(loadAllMap);

			return "index";
		}
		
		@RequestMapping("/saveHandler")
		public String saveHandler(String userPhone) {
			boolean bool=adminitorService.loadByPhone(userPhone);
			return bool?"redirect:loadAll":"redirect:error";
		}
		
		@RequestMapping("/deleteHandler")
		public String deleteHandler(String groupLeaderId) {
		    boolean bool=adminitorService.loadByLeaderId(groupLeaderId);
		//	boolean bool=adminitorService.delete();
			return bool?"redirect:loadAll":"redirect:error";
		}
        @RequestMapping("/loginHandler")
        public String loginHandler() {
		    boolean bool=true;
            return bool?"redirect:loadAll":"redirect:error";
    }
	}

