package com.example.blog.config;

import com.example.blog.model.Role;
import com.example.blog.model.BlogUser;
import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.BlogUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
@Slf4j
public class UserDataSetup implements ApplicationListener<ContextRefreshedEvent> {

    private BlogUserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    boolean alreadySetup = false;

    @Autowired
    public UserDataSetup(BlogUserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event){
        if (alreadySetup){
            return;
        }
    }

    @Transactional
    Role createRoleIfNotExists(String name){
        Role role = roleRepository.findByName(name);

        if(role == null){
            role = new Role(name);
            roleRepository.save(role);
        }
        return role;
    }
}
