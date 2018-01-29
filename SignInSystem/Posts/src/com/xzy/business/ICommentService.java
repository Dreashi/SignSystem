package com.xzy.business;

import com.xzy.web.entity.Comment;

import java.util.List;

public interface ICommentService {

    public List<Comment> loadAllComment();
    public Comment sendComment();
    public boolean deleteComment(int commentId);
}
