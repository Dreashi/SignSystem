package com.xzy.business.impl;

import com.xzy.business.IPostService;
import com.xzy.mybatis.dao.PostDao;
import com.xzy.web.entity.Post;
import com.xzy.web.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service("postService")
public class PostService implements IPostService{
	@Autowired
    private PostDao postDao;
	@Autowired
	private HttpSession session;


    public List<Post> loadAllPost() {
        return postDao.loadAllPost();
    }

    /**
     * 发帖子
     * @param user 发帖的用户
     * @param content 帖子的内容
     * 
     */
    public void sendPost(User sendUser, String content) {
        Post newPost=new Post(content,sendUser);
        postDao.sendPost(newPost);
        //postList.add(newPost);
    }

    public boolean deletePost(String[] ids){
    	String str1="";
    	for(int i=0; i<ids.length; i++) {
    		str1+=ids[i]+",";
    	}
    	String[] str2=str1.split(",");
    	List<Integer> idsList=new ArrayList<Integer>();
    	for(String str : str2) {
    		idsList.add(new Integer(str));
    	}
    	System.out.println(idsList);
    	int count=postDao.deletePost(idsList);
        return count>0?true:false;
    }

    public int supportPost() {
        return 0;
    }

	@Override
	public List<Post> loadPostById() {
		User loginUser=(User)session.getAttribute("loginUser");
		int userId=loginUser.getUserId();
		return postDao.loadPostById(userId);
	}
}
