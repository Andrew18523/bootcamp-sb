package com.bootcamp.demo.demo_api.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.infra.ApiUtil;
import com.bootcamp.demo.demo_api.infra.Scheme;
import com.bootcamp.demo.demo_api.model.Mapper;
import com.bootcamp.demo.demo_api.model.User;
import com.bootcamp.demo.demo_api.repository.UserRepository;
import com.bootcamp.demo.demo_api.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

  @Value("${api.endpoint.user}")
  String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private Mapper mapper;

  @Autowired
  private ApiUtil apiUtil;

  @Override
  public List<User> getUsers(){
    User[] userArr = restTemplate.getForObject(apiUtil.getUrl(Scheme.HTTPS, userEndpoint), User[].class);

    List<UserEntity> userList = this.covertArrToList(userArr).stream()//
    .map(u->mapper.map(u))//
    .collect(Collectors.toList());

    userRepository.saveAll(userList);
    return covertArrToList(userArr);
  }

  private List<User> covertArrToList(User[] userArr){
    return List.of(userArr);

    // public String getOpenRiceExample(){
    //   Map<String, String> map = new HashMap<>();
    //   map.put("conditionID", "10039");
    //   map.put("tmReservation","true");

    // }
  }
}
