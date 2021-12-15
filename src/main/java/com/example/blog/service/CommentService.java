package com.example.blog.service;


import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CommentService {
    Comment getById(Long id);

    Comment saveComment(Comment comment);

    Collection<Comment> getAllCommentByPost(Post post);

    void deleteComment(Comment comment);
}
