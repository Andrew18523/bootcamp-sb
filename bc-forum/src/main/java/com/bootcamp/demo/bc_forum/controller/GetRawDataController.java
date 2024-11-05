package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;

public interface GetRawDataController {

  @GetMapping ("/users")
  List<UserPlaceHolder> getUsers();

  @GetMapping ("/comments")
  List<CommentPlaceHolder> getComments();

  @GetMapping ("/posts")
  List<PostPlaceHolder> getPosts();
}
