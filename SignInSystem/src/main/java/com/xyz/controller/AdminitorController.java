package com.xyz.controller;

import java.util.*;

import com.xyz.model.Group;
import com.xyz.model.User;
import com.xyz.service.ipml.AdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(names= {"loadAllMap"})
public class AdminitorController {
		@Autowired
		private AdminitorService adminitorService;
		@RequestMapping("/loadAll")
		@ResponseBody
		public TreeMap<HashMap<Integer,User>,ArrayList<User>> loadAll() {
			List<User> userList=adminitorService.loadAll();
			List<Group> groupList=adminitorService.loadAllGroup();
			TreeMap<HashMap<Integer,User>,ArrayList<User>> loadAllMap = new TreeMap<HashMap<Integer,User>,ArrayList<User>>(
					new Comparator<HashMap<Integer,User>>() {
						@Override
						public int compare(HashMap s1, HashMap s2) {
							return (int)s1.keySet().iterator().next()>(int)s2.keySet().iterator().next()?1:-1;
						}
					}
			);
		//	((TreeMap)(loadAllMap.keySet())).keySet().iterator();
			//外层循环遍历所有组长
			for(int i = 0 ; i < groupList.size() ; i++ ) {
				Integer leaderId;
				Integer gropuId;
				if (groupList.get(i) != null){
					leaderId = groupList.get(i).getGroupLeaderId();
					gropuId = groupList.get(i).getGroupId();
					ArrayList<User> tempList = new ArrayList<>();
					//找到该组所有成员信息
					for (int j = 0; j < userList.size(); ) {
						//   tempList.clear();
						if (userList.get(j).getGroupId() .equals(gropuId) ) {
							tempList.add(userList.get(j));
							userList.remove(j);
						} else {
							j++;
						}
					}
					//区分组长和组员并放入map
					User groupLeader = null;
					HashMap<Integer,User> leadMap=new HashMap<Integer,User>();
					for (int k = 0; k < tempList.size(); ) {
						if (tempList.get(k).getUserId() .equals(leaderId) ) {
							groupLeader = tempList.get(k);
							tempList.remove(k);
						} else {
							k++;
						}
					}
					leadMap.put(gropuId,groupLeader);
					//放入map集合
					loadAllMap.put(leadMap, tempList);
				}
			}
			return loadAllMap;
		}
		@RequestMapping("/saveHandler")
		public String saveHandler(HttpServletRequest request,HttpServletResponse response) {
               String  Phone=request.getParameter("userPone");
			   boolean bool=adminitorService.loadByPhone(Phone);
			   return bool?"redirect:loadAll":"redirect:error";
		}
		@RequestMapping("/deleteHandler")
		public String deleteHandler(HttpServletRequest request,HttpServletResponse response) {
			String[] str=request.getParameterValues("gleaderList");
			List<Integer> list=new ArrayList<>();
			for(String s:str){
				list.add(Integer.parseInt(s));
			}
		    boolean bool=adminitorService.updateLeader(list);
			return bool?"redirect:loadAll":"redirect:error";
		}

        @RequestMapping("/loginHandler")
        public String loginHandler(HttpServletRequest request,String phone,String userPwd) {
		    boolean bool=true;
			return bool?"redirect:loadAll":"redirect:error.view";
    }
	}

