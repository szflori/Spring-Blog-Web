package com.example.blog.model.hateoas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class BlogUserResource extends RepresentationModel<BlogUserResource> {

    private String username;
    private String name;
    private String email;

}
