package com.bootcamp.demo.demo_api.model;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_api.entity.PostEntity;
import com.bootcamp.demo.demo_api.entity.UserEntity;

@Component
public class Mapper {
  
  public static UserEntity map(User user){
    return UserEntity.builder()//
    .name(user.getName())
    .username(user.getUsername())
    .email(user.getEmail())
    .phone(user.getPhone())
    .website(user.getWebsite())
    .build();
  }

  public static PostEntity postMap (Post post){
    return PostEntity.builder()
    .userId(post.getId())
    .title(post.getTitle())
    .body(post.getBody())
    .build();
  }
}
