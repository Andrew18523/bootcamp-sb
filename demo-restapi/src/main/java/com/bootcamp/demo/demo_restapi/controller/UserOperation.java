package com.bootcamp.demo.demo_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_restapi.model.User;


// 1. PathVariable
// 2. RequestParam
// 3. RequestBody
public class UserOperation {
  @GetMapping(value = "/users") //查詢
  List<User> getUsers();

  @GetMapping(value = "/user") //查詢
  User getUser(@RequestParam String userID);

  

  // @PostMapping    //CREATE -> 0 to 1 

  // @PatchMapping    // 改column

  // @DeleteMapping
}


