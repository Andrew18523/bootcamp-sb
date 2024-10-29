package com.bootcamp.demo.demo_restapi.mapper;

import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.dto.GovUserDto;

public class GovMapper {
  

  public static GovUserDto map(UserEntity userEntity){
    return GovUserDto.builder()
      .name(userEntity.getName())
      .email(userEntity.getEmail())
      .build();
  }
}
