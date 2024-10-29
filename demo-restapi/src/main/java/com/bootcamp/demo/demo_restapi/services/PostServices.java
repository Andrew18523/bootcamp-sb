package com.bootcamp.demo.demo_restapi.services;

import java.util.List;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.model.dto.PostDto;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface PostServices {
  List <PostDto> getPosts();

  List<PostEntity> getPostsFromDB() throws JsonProcessingException;
}
