package com.example.blog.rest;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path="/api/post", produces = "application/json")
@CrossOrigin(origins = "*")
public class PostRestController {
    private PostService postService;

    @Autowired
    public PostRestController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public CollectionModel<EntityModel<Post>> posts(){
        CollectionModel<EntityModel<Post>> postModel = CollectionModel.wrap(postService.getSearch(""));
        postModel.add(WebMvcLinkBuilder.linkTo(PostRestController.class)
                .withRel("post"));
        return postModel;
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> postById(@PathVariable Long id){
        Post p = postService.getPostId(id);

        if(p == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        if(post.getId() == null){
            post.setId(id);
        } else if (!Objects.equals(id, post.getId())){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(postService.savePost(post));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @RequestBody Post post){
        Post existing = postService.getPostId(id);
        if(existing == null){
            return ResponseEntity.notFound().build();
        }

        if(post.getTitle() != null){
            existing.setTitle(post.getTitle());
        }

        if(post.getText() != null){
            existing.setText(post.getText());
        }


        if(post.getBlogUser() != null){
            existing.setBlogUser(post.getBlogUser());
        }

        return ResponseEntity.ok(postService.savePost(existing));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        postService.deletePost(postService.getPostId(id));
    }

}
