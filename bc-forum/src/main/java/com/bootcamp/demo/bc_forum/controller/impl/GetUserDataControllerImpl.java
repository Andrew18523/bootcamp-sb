package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.GetUserDataController;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.UserCommentDto;
import com.bootcamp.demo.bc_forum.services.UserServices;

@RestController
public class GetUserDataControllerImpl implements GetUserDataController {

  @Autowired
  private UserServices userServices;

  @Override
  public List<UserEntity> getUserById(String id)  {
    List<UserEntity> list = new ArrayList<>();
    list.add(userServices.getUserById(Long.valueOf(id)));
    return list;
  }

  @Override
  public List<UserCommentDto> getUserCommentById(String id) {
    return userServices.getUserCommentById(Long.parseLong(id));

  } 
}
