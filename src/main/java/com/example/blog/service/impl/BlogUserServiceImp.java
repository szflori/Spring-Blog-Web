package com.example.blog.service.impl;

import com.example.blog.model.BlogUser;
import com.example.blog.model.Role;
import com.example.blog.repository.BlogUserRepository;
import com.example.blog.repository.RoleRepository;
import com.example.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Collection;

@Service
public class BlogUserServiceImp implements BlogUserService {

    private BlogUserRepository blogUserRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void BlogUserServiceImp(BlogUserRepository blogUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.blogUserRepository = blogUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public BlogUser getByUsername(String username) {
        return blogUserRepository.findByUsername(username);
    }

    @Override
    public BlogUser getByEmail(String email) {
        return blogUserRepository.findByEmail(email);
    }

    @Override
    public BlogUser getBlogUserById(Long id){
        return blogUserRepository.findById(id).orElse(null);
    }

    @Override
    public BlogUser saveBlogUser(BlogUser user) {
        Role role = roleRepository.findByName("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Arrays.asList(role));
        return blogUserRepository.saveAndFlush(user);
    }

    @Override
    public void deleteBlogUser(BlogUser user) {
        blogUserRepository.delete(user);
    }

    @Override
    public Collection<BlogUser> getAllBlogUser() {
       return blogUserRepository.findAll();
    }
}
