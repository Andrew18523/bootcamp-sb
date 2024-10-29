package com.bootcamp.demo.demo_restapi.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.CompanyEntity;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.dto.PostDto;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;

@Component
public class JPHmapper {
  
  public UserEntity map (UserDto user){
    return UserEntity.builder()
      .name(user.getName())
      .username(user.getUsername())
      .id(Long.valueOf(user.getId()))
      .phone(user.getPhone())
      .email(user.getEmail())
      .website(user.getWebsite())
      .build();
  }

  public PostEntity map(PostDto postDto){
    return PostEntity.builder()
            .id(postDto.getId())
            .title(postDto.getTitle())
            .body(postDto.getBody())
            .build();
  }

  public CompanyEntity map(UserDto.CompanyDto companyDto){
    return CompanyEntity.builder()
              .name(companyDto.getName())
              .catchPhrase(companyDto.getCatchPhrase())
              .bs(companyDto.getBs())
              .build();
  }
}
