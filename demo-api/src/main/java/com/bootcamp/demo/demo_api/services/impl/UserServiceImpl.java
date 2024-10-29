package com.bootcamp.demo.demo_api.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
  public User[] getUsers(){
    User[] userArr = restTemplate.getForObject(apiUtil.getUrl(Scheme.HTTPS, userEndpoint), User[].class);

    Arrays.asList(userArr).stream().forEach(user -> {
    userRepository.save(Mapper.map(user)); //
    });

    return userArr;
  }

  @Override
  public Optional<UserEntity> getUser(Long userID){
    return this.userRepository.findById(userID);
  }

  


    // public String getOpenRiceExample(){
    //   Map<String, String> map = new HashMap<>();
    //   map.put("conditionID", "10039");
    //   map.put("tmReservation","true");

    // }

}
