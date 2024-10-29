package com.bootcamp.demo.demo_api_practice.contorller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_api_practice.contorller.UserOperation;
import com.bootcamp.demo.demo_api_practice.model.User;
import com.bootcamp.demo.demo_api_practice.service.UserServices;

@RestController
public class UserController implements UserOperation {
  
  @Autowired
  private UserServices userServices;

    @Override
  public List<User> getUsers(){
    return userServices.getUsers();
  }
}
