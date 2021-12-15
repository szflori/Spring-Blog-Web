package com.example.blog.service;

import com.example.blog.model.BlogUser;

import java.util.Collection;

public interface BlogUserService {

    BlogUser getByUsername(String username);

    BlogUser getByEmail(String email);

    BlogUser saveBlogUser(BlogUser user);

    BlogUser getBlogUserById(Long id);

    void deleteBlogUser(BlogUser user);

     Collection<BlogUser> getAllBlogUser();
}
