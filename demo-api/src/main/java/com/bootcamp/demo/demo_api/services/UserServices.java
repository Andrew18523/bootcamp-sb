package com.bootcamp.demo.demo_api.services;

import java.util.Optional;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.model.User;

public interface UserServices {

  public User[] getUsers();

  Optional<UserEntity> getUser(Long userID);

  //UserEntity createNewUser(String name, String email, String phone);

  // User modifyUser(String userID,UserRequest userRequest);

  // User updateEmail(String userID,String email);

  // User updateMobile(String userID,String mobile);
} 