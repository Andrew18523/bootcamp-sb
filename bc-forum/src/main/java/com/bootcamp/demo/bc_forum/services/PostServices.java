package com.bootcamp.demo.bc_forum.services;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;

public interface PostServices {
  
  List<PostPlaceHolder> getPosts();

  List<PostPlaceHolder> getRawPosts();
}
