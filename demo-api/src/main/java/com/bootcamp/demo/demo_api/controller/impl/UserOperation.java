package com.bootcamp.demo.demo_api.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_api.model.User;

public interface UserOperation {

  @GetMapping("/users") // localhost:8085/users -> return List <User>
  List<User> getUsers();
}
