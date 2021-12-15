package com.example.blog.service;

import com.example.blog.model.BlogUser;
import com.example.blog.repository.BlogUserRepository;
import com.example.blog.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service("userDetailsService")
@Transactional
@Slf4j
public class BlogUserDetailsService implements UserDetailsService {

    private BlogUserRepository blogUserRepository;
    private RoleRepository roleRepository;

    @Autowired
    public BlogUserDetailsService(BlogUserRepository blogUserRepository, RoleRepository roleRepository){
        this.blogUserRepository = blogUserRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        BlogUser blogUser = blogUserRepository.findByUsername(usernameOrEmail);

        if(blogUser == null){
            blogUser = blogUserRepository.findByEmail(usernameOrEmail);

            if(blogUser == null){
                throw new UsernameNotFoundException("Could not find user with username (or email): " + usernameOrEmail);
            }
        }

        log.info(blogUser.getUsername() + "found");
        return blogUser;
    }

    public void registerUser(BlogUser user) {
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        user.setActive(true);

        blogUserRepository.save(user);

        log.info("user registered: " + user);
    }
}
