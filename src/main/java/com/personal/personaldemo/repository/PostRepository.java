package com.personal.personaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.personaldemo.model.Post;

import java.util.UUID;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, UUID>{
    //way1. jsql
    //way2. query create
    //List<Post> findByTitle(String title);
    List<Post> findByTitleContains(String title);
}
