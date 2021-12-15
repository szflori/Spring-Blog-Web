package com.example.blog.service.impl;

import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    public void CommentServiceImp(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Collection<Comment> getAllCommentByPost(Post post) {
        return commentRepository.findAllByPost(post);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}
