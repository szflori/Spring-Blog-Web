package com.example.blog.repository;

import com.example.blog.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
    BlogUser findByUsername(@Param("username") String username);
    BlogUser findByEmail(@Param("email") String email);
}
