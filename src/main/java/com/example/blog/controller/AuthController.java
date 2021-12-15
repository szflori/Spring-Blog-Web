package com.example.blog.controller;

import com.example.blog.model.BlogUser;
import com.example.blog.service.BlogUserDetailsService;
import com.example.blog.service.BlogUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class AuthController {

    @Autowired
    private BlogUserDetailsService blogUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String loginForm(BlogUser blogUser){
        return "login";
    }

    @PostMapping("/login-error")
    public String loginError(Model model, BlogUser blogUser){
        model.addAttribute("loginError", true);
        model.addAttribute("blogUser", blogUser);
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(BlogUser blogUser){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid BlogUser blogUser, BindingResult result){
        if(result.hasErrors()) {
            log.info("faild");
            return "register";
        }

        blogUser.setPassword(passwordEncoder.encode(blogUser.getPassword()));
        blogUserDetailsService.registerUser(blogUser);
        return "redirect:/login";
    }
}
