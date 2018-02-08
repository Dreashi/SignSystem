package com.xzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("")
public class ViewController {

    @RequestMapping("/index.view")
    public String indexView(){
        return "index";
    }

    @RequestMapping("/pushNews.view")
    public String pushNewsView(){
        return "pushNews";
    }


    @RequestMapping("/mark.view")
    public String markView(HttpServletRequest request, HttpServletResponse response) throws IOException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String mark = request.getParameter("mark");
        request.getSession().setAttribute("mark",mark);
        //System.out.println("view"+"----------"+mark);
        return "mark";
    }

    @RequestMapping("/error.view")
    public String errorView(){
        return "error";
    }

    @RequestMapping("/message.view")
    public String messageView(){
        return "message";
    }

    @RequestMapping("/saveMessage.view")
    public String saveMessageView(){return "saveMessage";}
}

