package com.bootcamp.demo.demo_api_practice.model;

import com.bootcamp.demo.demo_api_practice.entity.UserEntity;

public class Mapper {
    public UserEntity map(User user){
    return UserEntity.builder()//
      .name(user.getName())
      .username(user.getUsername())
      .email(user.getEmail())
      .phone(user.getPhone())
      .website(user.getWebsite())
      .build();
  }
}
