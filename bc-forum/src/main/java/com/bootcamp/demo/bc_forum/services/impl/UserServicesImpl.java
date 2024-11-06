package com.bootcamp.demo.bc_forum.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.exception.ErrorCode;
import com.bootcamp.demo.bc_forum.exception.UserNotFoundException;
import com.bootcamp.demo.bc_forum.model.dto.CommentDto;
import com.bootcamp.demo.bc_forum.model.dto.UserCommentDto;
import com.bootcamp.demo.bc_forum.model.dto.UserDto;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;
import com.bootcamp.demo.bc_forum.repository.UserRepository;
import com.bootcamp.demo.bc_forum.services.CommentServices;
import com.bootcamp.demo.bc_forum.services.UserServices;
import com.bootcamp.demo.bc_forum.util.Mapper;
import com.bootcamp.demo.bc_forum.util.UrlManager;

@Service
public class UserServicesImpl implements UserServices {


  @Value("${api.url.endpoint.user}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UrlManager urlManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mapper mapper;


  @Override
  public List<UserPlaceHolder> getUsers() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    List<UserPlaceHolder> userDtos = List.of(restTemplate.getForObject(url, UserPlaceHolder[].class));
    if (userRepository.findAll().isEmpty()){
      userDtos.stream().forEach(userDto->{
        userRepository.save(mapper.map(userDto));
      });
    }
    return userDtos;
  }

  @Override
  public List<UserPlaceHolder> getRawUsers() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    return List.of(restTemplate.getForObject(url, UserPlaceHolder[].class));
  }

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);
  }

  @Override
  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity getUserById(Long id) {
    return this.getAll().stream()
      .filter(user ->id.equals(user.getId())
      )
      .findFirst()
      .orElseThrow(()-> 
        new UserNotFoundException(ErrorCode.USER_NOT_FIND.getMessage()));
  }

  @Override
  public List<UserCommentDto> getUserCommentById(Long id) {
    UserEntity user =this.getAll().stream()
      .filter(userEntity -> id.equals(userEntity.getId()))
      .findFirst()
      .get();
    
    UserDto userDto = mapper.map(user);

    List<CommentDto> targetCommentDto = userDto.getPosts().stream()
      .flatMap(postDTO -> postDTO.getComments().stream())
      .collect(Collectors.toList());

    List<UserCommentDto> result = new ArrayList<>();
    UserCommentDto target = UserCommentDto.builder()
      .comments(targetCommentDto)
      .id(userDto.getId())
      .username(userDto.getUsername())
      .build();

      result.add(target);
      return result;
  }
}
