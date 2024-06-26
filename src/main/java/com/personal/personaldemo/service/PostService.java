package com.personal.personaldemo.service;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.personal.personaldemo.model.Post;
import com.personal.personaldemo.repository.PostRepository;
import com.personal.personaldemo.mapper.PostMapper;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<Post> findPostList(String title){
        return postRepository.findByTitleContains(title);
    }

    public List<Post> postList(){
        return postRepository.findAll();
        //return postMapper.listPost(); mybatis사용방식
    }

    /* mybatis사용방식
    public List<Post> postList_mybatis(){
        return postMapper.listPost();
    }
     */
}
