package com.xzy.service.ipml;


import com.xzy.dao.ICommentDao;
import com.xzy.dao.IPostDao;
import com.xzy.dao.IPostStatusDao;
import com.xzy.dao.IUserDao;
import com.xzy.model.Post;
import com.xzy.model.PostStatus;
import com.xzy.model.Users;
import com.xzy.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("postService")
public class PostService implements IPostService {
	@Autowired
	private IPostStatusDao postStatusDao;
	@Autowired
    private IPostDao postDao;
	@Autowired
	private ICommentDao commentDao;
	@Autowired
	private IUserDao userDao;

	//按时间顺序加载帖子
	@Override
    public List<Post> loadAllPostByTime() {
        return postDao.loadAllPostByTime();
    }
    //按热度加载帖子
	@Override
    public List<Post> loadAllPostByHeat(){
    	return postDao.loadAllPostByHeat();
    }

    //发帖
	@Override
    public boolean sendPost(int userId, String content) {
		Users sendUser=userDao.selectUserByUserId(userId);
        Post newPost=new Post(content,sendUser);
        int count=postDao.sendPost(newPost);
        return count>0?true:false;
    }

    //删帖
	@Override
    public boolean deletePost(int postId){
		int count;
		Post post = postDao.loadByPostId(postId);
		System.out.println();
		System.out.println(post);
		System.out.println();

		if (post!=null){
			//加载帖子的所有评论
			List<Integer> commentIdList=commentDao.loadCommentsIdByPostId(postId);

			System.out.println();
			System.out.println(commentIdList);
			System.out.println();

			if(!commentIdList.isEmpty()) {
				//删除评论的所有回复
				commentDao.deleteCommentByParentCommentId(commentIdList);
				//删除所有评论
				commentDao.deleteCommentsById(commentIdList);
			}
			//删除帖子
			count=postDao.deletePost(postId);
		}else {
			count = -1;
		}

        return count>0?true:false;
    }

    //按页加载帖子
    public List<Post> loadPostPage(int page){
		int fPage=(page-1)*10;
		return postDao.loadPostPage(fPage);
	}

    //对帖子点赞
	@Override
    public int addSupportToPost(int userId, int postId) {
    	PostStatus postStatus=new PostStatus(userId, postId);
    	int count=postStatusDao.insertPostStatus(postStatus);
    	if(count>0) {
			count = postDao.addSupportCount(postId);
			if(count>0)
				count = postDao.loadSupportCount(postId);
			else count=-1;
		}else	count=-1;
        return count;
    }

    //取消对帖子的赞
    @Override
	public int subSupportToPost(int userId, int postId) {
    	PostStatus postStatus=new PostStatus(userId, postId);
    	int count=postStatusDao.deletePostStatus(postStatus);
    	if(count>0) {
			count = postDao.subSupportCount(postId);
			if(count>0)	count = postDao.loadSupportCount(postId);
			else	count=-1;
		}else count=-1;
		return count;
	}


	//加载当前用户的帖子
	@Override
	public List<Post> loadPostById(int userId) {
		return postDao.loadPostById(userId);
	}

	
}
