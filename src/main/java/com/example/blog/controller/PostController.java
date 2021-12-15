package com.example.blog.controller;


import com.example.blog.model.BlogUser;
import com.example.blog.model.Post;
import com.example.blog.service.BlogUserService;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostService;
import com.example.blog.service.impl.PostServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("/post")
@Slf4j
public class PostController {

    private PostService postService;
    private BlogUserService blogUserService;
    private CategoryService categoryService;

    @Autowired
    public void setPostService(PostService postService, BlogUserService blogUserService, CategoryService categoryService){

        this.postService = postService;
        this.blogUserService = blogUserService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home(Model model, @Param("keyword") String keyword){
        Collection<Post> posts = postService.getSearch(keyword);
        model.addAttribute("posts", posts);
        model.addAttribute("keyword", keyword);
        return "/home";
    }

    @PostMapping
    public String homePost(Model model, @Param("keyword") String keyword){
        Collection<Post> posts = postService.getSearch(keyword);
        model.addAttribute("posts", posts);
        model.addAttribute("keyword", keyword);
        return "/home";
    }

    @GetMapping("/post-form/{id}")
    public String getPostForm(@PathVariable long id, Model model){
        Post post = postService.getPostId(id);
        model.addAttribute("post", post);
        return "post-form";
    }

    @PostMapping("/post-form/{id}")
    public String postPostForm(@PathVariable long id, Model model){
        Post post = postService.getPostId(id);
        model.addAttribute("post", post);
        return "post-form";
    }

    @GetMapping("/create")
    public String showPostCreateForm(Post post, Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "post-create";
    }

    @PostMapping("/create")
    public String createPost(@Valid Post post, Principal principal, BindingResult result){
        log.info("Create");
        if(result.hasErrors()){
            return "post-create";
        }
        BlogUser user = blogUserService.getByUsername(principal.getName());
        post.setBlogUser(user);
        postService.savePost(post);
        log.info("Create save");
        return "redirect:/post";
    }


    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable long id){
        Post post = postService.getPostId(id);
        postService.deletePost(post);
        return "redirect:/post";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable long id, Model model){
        Post e = postService.getPostId(id);
        model.addAttribute("post", e);
        return "post-create";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@Valid Post e, BindingResult result){
        if(result.hasErrors()){
            return "post-create";
        }
        postService.savePost(e);
        return "redirect:/post";
    }



}
