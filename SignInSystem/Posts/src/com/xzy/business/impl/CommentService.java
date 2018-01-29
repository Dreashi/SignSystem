package com.xzy.business.impl;

import com.xzy.business.ICommentService;
import com.xzy.web.entity.Comment;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService{
    public List<Comment> loadAllComment() {
        return null;
    }

    public Comment sendComment() {
        return null;
    }

    public boolean deleteComment(int commentId) {
        return false;
    }
}
