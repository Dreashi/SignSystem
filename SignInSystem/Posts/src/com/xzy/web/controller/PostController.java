package com.xzy.web.controller;

import com.xzy.business.IPostService;
import com.xzy.web.entity.Post;
import com.xzy.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private IPostService postService;
    @Autowired
    private HttpSession session;

    @RequestMapping("/sendPostHandler")
    public String sendPostHandler(String postContent){
    	User sendUser=(User) session.getAttribute("loginUser");
       session.setAttribute("postContent",postContent);
        postService.sendPost(sendUser,postContent);
        List<Post> allPostList=loadAllPost();
        session.setAttribute("allPostList",allPostList);
        return "loadAllPost";
    }

    @RequestMapping("/loadAllHandler")
    public List<Post> loadAllPost(){
        return postService.loadAllPost();
    }
    
    @RequestMapping("/loadPostByIdHandler")
    public String loadPostByIdHandler() {
    	List<Post> userPostList=postService.loadPostById();
    	session.setAttribute("userPostList", userPostList);
    	return "loadPostById";
    }
    
    @RequestMapping("/deletePostHandler")
    public String deletePostHandler(String[] ids) {
    	boolean bool=postService.deletePost(ids);
    	String str=null;
    	if(bool==true) {
    		str=loadPostByIdHandler();
    	}else {
    		str="error";
    	}
    	return str;
    }


}
