package com.bootcamp.demo.demo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_api.model.Post;

public interface PostOperation {
  
  @GetMapping("/posts") // localhost:8085/Post
  Post[] getPosts();
}
