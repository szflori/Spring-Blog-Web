package com.example.blog.controller;

import com.example.blog.model.Comment;
import com.example.blog.model.Post;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    @Autowired
    public void setCommentService(CommentService commentService, PostService postService){
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping("/create/{id}")
    public String showCreateCommentForm(@PathVariable Long id, Model model){
        Post post = postService.getPostId(id);
        Comment comment = new Comment();
        comment.setPost(post);
        model.addAttribute("comment", comment);
        return "comment-create";
    }

    @PostMapping("/create")
    public String createComment(@Valid Comment comment, BindingResult result, Model model){
        log.info("Create Comment");
        if(result.hasErrors()){
            return "comment-create";
        }
        Collection<Comment> comments = commentService.getAllCommentByPost(comment.getPost());
        commentService.saveComment(comment);
        log.info("Create Comment save");
        model.addAttribute("comments", comments);
        return "redirect:/post/post-form/" + comment.getPost().getId();
    }


}
