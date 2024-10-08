package com.bootcamp.demo.demo_api.model;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_api.entity.UserEntity;

@Component
public class Mapper {
  
  public UserEntity map(User user){
    return UserEntity.builder()//
    .name(user.getName())
    .build();
  }
}
