package com.example.blog.repository;

import com.example.blog.model.BlogUser;
import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE %?1%"
            + " OR p.text LIKE %?1%"
            + " OR p.createdBy LIKE %?1%")
    Collection<Post> findAllByOrderByCreatedAtAsc(String keyword);
    Collection<Post> findAllByBlogUser(BlogUser blogUser);
}
