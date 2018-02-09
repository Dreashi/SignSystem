package com.xzy.controller;

import com.xzy.model.Post;
import com.xzy.service.IPostService;
import com.xzy.service.IPostStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IPostStatusService postStatusService;

    //发帖子处理ok
    @RequestMapping(value="/sendPostHandler")
    @ResponseBody
    public boolean sendPostHandler(@RequestParam("userId") int userId,
                                   @RequestParam("postContent") String postContent){
        boolean bool=postService.sendPost(userId,postContent);
        return bool;
    }

   //加载帖子并按时间排序ok
    @ResponseBody
    @RequestMapping(value="/loadAllPostByTimeHandler")
    public List<Post> loadAllPostByTime(HttpServletRequest req, HttpServletResponse resp){
		List<Post> allPostList=postService.loadAllPostByTime();
//    	List<Integer> supportList = postStatusService.loadPostStatus(userId);
//    	Map<List, List> postMap = new HashMap<>();
//    	postMap.put(supportList,allPostList);
        return allPostList;
//		json.jsonP(req,resp,allPostList);
    }

    //加载帖子并按热度排序ok
//    @RequestMapping("/loadAllPostByHeatHandler")
//	@ResponseBody
//    public String loadAllPostByHeatHandler() {
//    	List<Post> allPostList=postService.loadAllPostByHeat();
//        return "loadAllPost";
//    }

    //加载当前用户的帖子ok
    @RequestMapping("/loadPostByIdHandler")
    @ResponseBody
    public List<Post> loadPostByIdHandler(@RequestParam("userId")int userId) {
    	List<Post> userPostList=postService.loadPostById(userId);
    	return userPostList;
    }

    //删除帖子
    @RequestMapping("/deletePostHandler")
    @ResponseBody
    public boolean deletePostHandler(@RequestParam("postId")int postId) {
    	boolean bool=postService.deletePost(postId);
    	return bool;
    }

    //按页加载帖子ok
    @RequestMapping("/loadPostPageHandler")
    @ResponseBody
	public List<Post> loadPostPageHandler(@RequestParam("page")int page){
    	List<Post> postList=postService.loadPostPage(page);
    	return postList;
	}
    
    //加载帖子的点赞状态
//    @ResponseBody
////    public List<PostStatus> loadPostStatusHandler(){
////    	return postStatusService.loadPostStatus(userId);
////    }

    //给帖子点赞ok
    @RequestMapping("/addSupportToPostHandler")
	@ResponseBody
    public int addSupportToPostHandler(@RequestParam("userId")int userId, @RequestParam("postId")int postId) {
    	return postService.addSupportToPost(userId,postId);
    }

    //对帖子取消赞ok
	@RequestMapping("/subSupportToPostHandler")
	@ResponseBody
    public int subSupportToPostHandler(@RequestParam("userId")int userId, @RequestParam("postId")int postId) {
    	return postService.subSupportToPost(userId,postId);
    }


}
