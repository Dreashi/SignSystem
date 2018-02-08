package com.xzy.controller;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class JsonpController {
    public static void jsonP(HttpServletRequest request, HttpServletResponse response, Map pmap){

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
