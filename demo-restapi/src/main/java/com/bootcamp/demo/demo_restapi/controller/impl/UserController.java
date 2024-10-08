package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.model.User;

import com.bootcamp.demo.demo_restapi.services.UserServices;
import com.bootcamp.demo.demo_restapi.controller.UserOperation;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserServices userService;

  @Override
  public List<User> getUsers() {
    return List.of(userService.getUsers());
  }

  @Override
  public User getUser(String userID) {
    return userService.getUser(Long.parseLong(userID));
  }

  @Override
  public User createNewUser (UserRequest userFrom){
    String name = userFrom.getName();
    String email = userFrom.getemail();
    String phone = userFrom.getPhone();
    return userService.createNewUser(name,email,phone);
  }

}
