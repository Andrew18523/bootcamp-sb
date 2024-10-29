package com.bootcamp.demo.demo_restapi.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.bootcamp.BusinessException;
import com.bootcamp.demo.demo_restapi.bootcamp.ErrorCode;
import com.bootcamp.demo.demo_restapi.bootcamp.Scheme;
import com.bootcamp.demo.demo_restapi.bootcamp.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.mapper.GovMapper;
import com.bootcamp.demo.demo_restapi.mapper.JPHmapper;
import com.bootcamp.demo.demo_restapi.model.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.services.UserServices;

@Service
public class UserServiceHolder implements UserServices {

  // ! @Value: Before @Service bean created, Spring finds "api.url" value from
  // application.yml. If the url cannot be found, server will not able to start

  // Field Injection
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.user}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JPHmapper jphMapper;

  // Constructor Injection
  // @Autowired
  // public UserServiceHolder(@Value("${api.url.domain}") String domain, 
  //     @Value("${api.url.endpoint}") String endpoint, RestTemplate restTemplate) {
  //   this.domain = domain;
  //   this.endpoint = endpoint;
  //   this.restTemplate = restTemplate;
  // }

  @Override
  public UserDto[] getUsers() {
    // call API from "jsonplaceholder.typicode.com/users"
    // we receive User Array

    // getForObject(): call API + serialize result and convert to User[]
    String url = UrlManager.builder() //
        //.scheme(Scheme.HTTPS) //
        .domain(this.domain) //
        .endpoint(this.endpoint) //
        .build() //
        .toUriString();

    System.out.println("Check url=" + url); // debug

    UserDto[] users = this.restTemplate.getForObject(url, UserDto[].class);
    //save user into database
    Arrays.asList(users).stream().forEach(user -> {
    userRepository.save(this.jphMapper.map(user)); //
    });

    // System.out.println("users=" + Arrays.toString(users));
    return users;
  }

  @Override
  public List<UserDto> getUsersFromWebsite() {
    String url = UrlManager.builder() //
        //.scheme(Scheme.HTTPS) //
        .domain(this.domain) //
        .endpoint(this.endpoint) //
        .build() //
        .toUriString();
    UserDto[] users = this.restTemplate.getForObject(url, UserDto[].class);
    Arrays.asList(users).stream().forEach(user -> {
      userRepository.save(this.jphMapper.map(user)); //
      });
    return Arrays.asList(users);
  }

  @Override
  public Optional<UserEntity> getUsersFromDB(Long id){
    return this.userRepository.findById(id);
  }


  // @Override
  // public Boolean deleteById(Long id){
  //   if(this.userRepository.existsById(id)){
  //     this.userRepository.deleteById(id);
  //     return true;
  //   }
  //   return false;
  // }
  @Override
  public void deleteById(Long id){
    if(! this.userRepository.existsById(id)){
      throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
    } this.userRepository.deleteById(id);
  }

  @Override
  public UserEntity getUserByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }
}
