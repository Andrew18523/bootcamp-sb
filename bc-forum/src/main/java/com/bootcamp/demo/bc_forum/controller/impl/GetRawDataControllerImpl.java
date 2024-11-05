package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.GetRawDataController;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;
import com.bootcamp.demo.bc_forum.services.CommentServices;
import com.bootcamp.demo.bc_forum.services.PostServices;
import com.bootcamp.demo.bc_forum.services.UserServices;

@RestController
public class GetRawDataControllerImpl implements GetRawDataController {
  @Autowired
  private UserServices userServices;

  @Autowired
  private PostServices postServices;

  @Autowired
  private CommentServices commentServices;

  @Override
  public List<UserPlaceHolder> getUsers(){
    return this.userServices.getUsers();
  }

  @Override
  public List<CommentPlaceHolder> getComments() {
    return this.commentServices.getComments();
  }

  @Override
  public List<PostPlaceHolder> getPosts() {
    return this.postServices.getPosts();
  }

  
}
