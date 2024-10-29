package com.bootcamp.demo.demo_api_practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_api_practice.entity.UserEntity;
import com.bootcamp.demo.demo_api_practice.infra.ApiUtil;
import com.bootcamp.demo.demo_api_practice.infra.Scheme;
import com.bootcamp.demo.demo_api_practice.model.Mapper;
import com.bootcamp.demo.demo_api_practice.model.User;
import com.bootcamp.demo.demo_api_practice.repository.UserRepository;
import com.bootcamp.demo.demo_api_practice.service.UserServices;

@Service
public class UserServicesImpl implements UserServices {
  @Value("${api.endpoint.user}")
  String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ApiUtil apiUtil;

  @Autowired
  private Mapper mapper;

  @Override
  public List<User> getUsers() {
    User[] userArr = restTemplate
        .getForObject(apiUtil.getUrl(Scheme.HTTPS, userEndpoint), User[].class);

    List<UserEntity> userList = this.convertArrToList(userArr).stream()//
    .map(u->mapper.map(u))//
    .collect(Collectors.toList());

    userRepository.saveAll(userList);
    return this.convertArrToList(userArr);
  }

  private List<User> convertArrToList(User[] userArr) {
    return List.of(userArr);
  }
}
