package com.xzy.controller;

import com.xzy.model.Group;
import com.xzy.model.Users;
import com.xzy.service.ipml.AdminitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class AdminitorController {
		@Autowired
		private AdminitorService adminitorService;
		@RequestMapping("/loadAll")
		@ResponseBody
		public void loadAll(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			List<Users> usersList =adminitorService.loadAll();
			List<Group> groupList=adminitorService.loadAllGroup();
			TreeMap<Integer,ArrayList<Users>> loadAllMap = new TreeMap<Integer, ArrayList<Users>>(
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
					ArrayList<Users> tempList = new ArrayList<>();
					//找到该组所有成员信息
					for (int j = 0; j < usersList.size(); ) {
						if (usersList.get(j).getGroupId()==gropuId ) {
							tempList.add(usersList.get(j));
							usersList.remove(j);
						} else {
							j++;
						}
					}
					//区分组长和组员
					Users groupLeader = null;
					ArrayList<Users> tempList1 = new ArrayList<>();
					for (int k = 0; k < tempList.size(); ) {
						if (tempList.get(k).getUserId() ==(leaderId) ) {
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
            JsonpController.jsonP(request,response,loadAllMap);
		}
		@RequestMapping("/saveHandler")
		@ResponseBody
		public void saveHandler(HttpServletRequest request, HttpServletResponse response, String userPhone) throws UnsupportedEncodingException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Map<String,Integer> pmap=new HashMap<>();
			  if(userPhone!=null) {
				 boolean bool = adminitorService.loadByPhone(userPhone);
                pmap.put("suc",1);
			 }else{
				  pmap.put("err",2);
			  }
            JsonpController.jsonP(request,response,pmap);
		}
		@RequestMapping("/deleteHandler")
		@ResponseBody
		public void deleteHandler(HttpServletRequest request, HttpServletResponse response, String gleaderList) throws UnsupportedEncodingException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
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
		JsonpController.jsonP(request,response,pmap);
		}
	}


