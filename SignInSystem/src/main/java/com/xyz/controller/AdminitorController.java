package com.xyz.controller;

import java.util.*;

import com.xyz.model.Group;
import com.xyz.model.User;
import com.xyz.service.ipml.AdminitorService;
import net.sf.json.JSONObject;
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
		public TreeMap<Integer,ArrayList<User>> loadAll() {
			List<User> userList=adminitorService.loadAll();
			List<Group> groupList=adminitorService.loadAllGroup();
			TreeMap<Integer,ArrayList<User>> loadAllMap = new TreeMap<Integer, ArrayList<User>>(
					new Comparator<Integer>() {
						@Override
						public int compare(Integer s1, Integer s2) {
							return s1-s2;
						}
					}
			);
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
						if (userList.get(j).getGroupId() .equals(gropuId) ) {
							tempList.add(userList.get(j));
							userList.remove(j);
						} else {
							j++;
						}
					}
					//区分组长和组员
					User groupLeader = null;
					ArrayList<User> tempList1 = new ArrayList<>();
					for (int k = 0; k < tempList.size(); ) {
						if (tempList.get(k).getUserId() .equals(leaderId) ) {
							groupLeader = tempList.get(k);
							tempList.remove(k);
						} else {
							k++;
						}
					}
					tempList1.add(groupLeader);
					for (int l = 0; l < tempList.size();l++ ) {
						tempList1.add(tempList.get(l));
					}
					loadAllMap.put(gropuId, tempList1);
				}
			}
			return loadAllMap;
		}
		@RequestMapping("/saveHandler")
		public String saveHandler(HttpServletRequest request,HttpServletResponse response,String userPhone) {
              System.out.println(userPhone+"----------------");
			   boolean bool=adminitorService.loadByPhone(userPhone);
			   return bool?"redirect:loadAll":"redirect:error";
		}
		@RequestMapping("/deleteHandler")
		public String deleteHandler(HttpServletRequest request,HttpServletResponse response) {
			String[] str=request.getParameterValues("gleaderList");
			System.out.println(str+"----------------------");
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
			return bool?"redirect:loadAll":"redirect:error";
    }
	}

