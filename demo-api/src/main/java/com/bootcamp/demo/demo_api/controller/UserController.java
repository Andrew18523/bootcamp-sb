package com.bootcamp.demo.demo_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_api.controller.impl.UserOperation;
import com.bootcamp.demo.demo_api.model.User;
import com.bootcamp.demo.demo_api.services.UserServices;

@RestController // -> @ Controller + @ResponseBody
public class UserController implements UserOperation {

  @Autowired
  private UserServices userServices;

  @Override
  public List<User> getUsers(){
    return userServices.getUsers();
  }
}
