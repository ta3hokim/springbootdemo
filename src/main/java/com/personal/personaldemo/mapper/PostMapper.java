package com.personal.personaldemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.personal.personaldemo.model.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<Post> listPost();
}
