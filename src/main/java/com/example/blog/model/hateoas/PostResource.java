package com.example.blog.model.hateoas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
public class PostResource extends RepresentationModel<PostResource> {

    private String title;
    private String text;
    private String category;
    private BlogUserResource blogUser;
}
