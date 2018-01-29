package com.xzy.business;

import com.xzy.web.entity.Post;
import com.xzy.web.entity.User;

import java.util.List;

public interface IPostService {

    public List<Post> loadAllPost();
    public List<Post> loadPostById();
    public void sendPost(User sendUser, String content);
    public boolean deletePost(String[] ids);
    public int supportPost();
}
