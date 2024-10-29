package com.bootcamp.demo.demo_api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.model.User;

public interface UserOperation {

  @GetMapping("/users") // localhost:8085/users -> return List <User>
  User[] getUsers();

  @GetMapping("/user/{id}")
  UserEntity getUser(@PathVariable String id);
}
