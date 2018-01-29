package com.xyz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aliyuncs.exceptions.ClientException;
@WebServlet(name = "numberServlet", urlPatterns = { "/numberServlet" })
public class NumberServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone=req.getParameter("phone");
		String codeNumber=req.getParameter("number");	
	    SmsDemo smsDemo=new SmsDemo();
	    String  number= smsDemo.createRandomNum(6);
	    HttpSession session = req.getSession();
	    session.setAttribute("code", number);
	     try {
			smsDemo.sendSms(phone,number);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
