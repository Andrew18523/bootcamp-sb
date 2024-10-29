package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_restapi.bootcamp.GeneralResponse;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.dto.BankUserDto;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;


// 1. PathVariable
// 2. RequestParam
// 3. RequestBody
public interface BankUserOperation {
  @GetMapping(value = "/users") //查詢
  UserDto[] getUsers();

  @GetMapping(value = "/db/users/{id}")
  UserEntity getUsersFromDBById(@PathVariable Long id);

  @DeleteMapping(value = "/db/users/{id}") // not duplicated as @DeleteMapping
  String deleteUserFromDBById(@PathVariable Long id);

  @GetMapping(value = "/user")
  GeneralResponse<BankUserDto> getUserByUsername (@RequestParam String username);
  // Controller Layer: covert UserEntity -> User -> GeneralResponse<User>
}


