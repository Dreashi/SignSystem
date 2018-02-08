package com.xzy.controller;

import java.util.*;

import com.xzy.model.Group;
import com.xzy.model.User;
import com.xzy.service.ipml.AdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminitorController {
		@Autowired
		private AdminitorService adminitorService;
		@RequestMapping("/loadAll")
		@ResponseBody
		public TreeMap<Integer,ArrayList<User>> loadAll() {
			List<User> userList =adminitorService.loadAll();
			List<Group> groupList=adminitorService.loadAllGroup();
			TreeMap<Integer,ArrayList<User>> loadAllMap = new TreeMap<Integer, ArrayList<User>>(
					new Comparator<Integer>() {
						@Override
						public int compare(Integer s1, Integer s2) {
							return s1-s2;
						}
					});
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
						if (userList.get(j).getGroupId()==gropuId)  {
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
						if (tempList.get(k).getUserId()==leaderId) {
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
		@ResponseBody
		public Map<String, Integer> saveHandler(HttpServletRequest request,HttpServletResponse response,String userPhone) {
			Map<String,Integer> pmap=new HashMap<>();
			  if(userPhone!=null) {
				 boolean bool = adminitorService.loadByPhone(userPhone);
                pmap.put("suc",1);
			 }else{
				  pmap.put("err",2);
			  }
			  return pmap;
		}
		@RequestMapping("/deleteHandler")
		@ResponseBody
		public Map<String, Integer> deleteHandler(HttpServletRequest request,HttpServletResponse response,String gleaderList) {
			System.out.println(gleaderList + "---------------------");
			Map<String, Integer> pmap = new HashMap<>();
			if (gleaderList != null) {
				String[] str = gleaderList.split(",");
				List<Integer> list = new ArrayList<>();
				for (String s : str) {
					list.add(Integer.parseInt(s));
				}
				boolean bool = adminitorService.updateLeader(list);
				pmap.put("suc", 1);
			} else {
				pmap.put("err", 0);
			}
			   return pmap;
		}
	}

