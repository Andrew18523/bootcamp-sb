package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.UserCommentDto;

public interface GetUserDataController {

  @GetMapping(value = "/user/{id}")
  List<UserEntity> getUserById(@PathVariable String id);

  @GetMapping(value = "user_comment") //?userID=1
  List<UserCommentDto> getUserCommentById(@RequestParam String id);
}
