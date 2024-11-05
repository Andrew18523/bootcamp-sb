package com.bootcamp.demo.bc_forum.services;

import java.util.List;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.UserCommentDto;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;

public interface UserServices {

  List<UserPlaceHolder> getUsers();

  List<UserPlaceHolder> getRawUsers();

  List<UserEntity> saveAll(List<UserEntity> userEntities);

  List<UserEntity> getAll();

  UserEntity getUserById(Long id);

  List<UserCommentDto> getUserCommentById(Long id);
}
