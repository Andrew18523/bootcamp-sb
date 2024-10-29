package com.bootcamp.demo.demo_restapi.mapper;

import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.dto.BankUserDto;

public class BankMapper {
  public static BankUserDto map(UserEntity entity) {
    return BankUserDto.builder() //
        .name(entity.getName()) //
        .email(entity.getEmail()) //
        .website(entity.getWebsite()) //
        .build();
  }
}
