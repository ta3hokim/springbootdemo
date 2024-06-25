package com.personal.personaldemo.service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.personal.personaldemo.model.Post;
import com.personal.personaldemo.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> postList(){
        return postRepository.findAll();
    }
}
