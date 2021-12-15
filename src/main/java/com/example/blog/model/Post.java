package com.example.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;


@Data
@Entity
@NoArgsConstructor
public class Post extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    @NotEmpty(message = "Text cannot be empty")
    @Size(min = 10, max = 1000, message = "Text must be at least 10 characters long")
    private String text;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Collection<Comment> comments;


    @ManyToOne
    private Category category;


    @ManyToOne(cascade = CascadeType.ALL)
    private BlogUser blogUser;

}
