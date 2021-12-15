package com.example.blog.service;

import com.example.blog.model.BlogUser;
import com.example.blog.model.Post;

import java.util.Collection;



public interface PostService {
    Post getPostId(Long id);

    Post savePost(Post post);

    Collection<Post> getAllPostByUser(BlogUser user);

    Collection<Post> getSearch(String keyword);

    public void deletePost(Post post);
}
