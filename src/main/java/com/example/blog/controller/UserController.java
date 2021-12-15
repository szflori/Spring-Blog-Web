package com.example.blog.controller;

import com.example.blog.model.BlogUser;
import com.example.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {


    private BlogUserService blogUserService;

    @GetMapping
    public String listOfUsers(Model model){
        model.addAttribute("blogUsers", blogUserService.getAllBlogUser());
        return "users-page";
    }

    @PostMapping
    public String listOfUsersPost(Model model){
        model.addAttribute("blogUsers", blogUserService.getAllBlogUser());
        return "users-page";
    }

    @GetMapping("/create")
    public String showCreateForm(BlogUser blogUser){
        return "user-create";
    }

    @PostMapping("/create")
    public String createUser(@Valid BlogUser blogUser, BindingResult result){
        if(result.hasErrors()){
            return "user-create";
        }
        blogUserService.saveBlogUser(blogUser);
        return "redirect:/user";
    }

    @GetMapping("/user-form/{id}")
    public String getUserForm(@PathVariable long id, Model model){
        BlogUser blogUser = blogUserService.getBlogUserById(id);
        model.addAttribute("blogUser", blogUser);
        return "user-form";
    }

    @PostMapping("/user-form/{id}")
    public String postUserForm(@PathVariable long id, Model model){
        BlogUser blogUser = blogUserService.getBlogUserById(id);
        model.addAttribute("blogUser", blogUser);
        return "post-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        BlogUser user = blogUserService.getBlogUserById(id);
        blogUserService.deleteBlogUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUserFrom(@PathVariable long id, Model model){
        BlogUser u = blogUserService.getBlogUserById(id);
        model.addAttribute("blogUser", u);
        return "user-create";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@Valid BlogUser u, BindingResult result){
        if(result.hasErrors()){
            return "user-create";
        }
        //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //u.setPhoto(fileName);
        u.setPassword(blogUserService.getBlogUserById(u.getId()).getPassword());
        blogUserService.saveBlogUser(u);
        //String uploadDir = "user-photos/" + u.getId();
        //uploadFileSave(uploadDir, fileName, multipartFile);
        return "redirect:/user";
    }

    @Autowired
    public void setBlogUserService(BlogUserService blogUserService){
        this.blogUserService = blogUserService;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    private void uploadFileSave(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException{
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioe){
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

}
