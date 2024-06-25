package com.personal.personaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.personaldemo.model.Post;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID>{

}
