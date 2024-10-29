package com.bootcamp.demo.demo_api.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_api.controller.PostOperation;
import com.bootcamp.demo.demo_api.model.Post;
import com.bootcamp.demo.demo_api.services.PostService;

@RestController
public class PostController implements PostOperation {
  
  @Autowired
  private PostService postService;

  @Override
  public Post[] getPosts(){
    return postService.getPosts();
  }
}
