package com.example.blog.service.impl;

import com.example.blog.model.BlogUser;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;

    @Autowired
    public void PostServiceImp(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public Post getPostId(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Collection<Post> getAllPostByUser(BlogUser user) {
        return postRepository.findAllByBlogUser(user);
    }


    @Override
    public Collection<Post> getSearch(String keyword) {
        if(keyword != null){
            return postRepository.findAllByOrderByCreatedAtAsc(keyword);
        }
        return postRepository.findAll();
    }

    @Override
    public void deletePost(Post post) {
    postRepository.delete(post);
    }

}

