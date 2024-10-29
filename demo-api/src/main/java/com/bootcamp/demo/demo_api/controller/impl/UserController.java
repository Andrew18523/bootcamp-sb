package com.bootcamp.demo.demo_api.controller.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_api.controller.UserOperation;
import com.bootcamp.demo.demo_api.entity.UserEntity;
import com.bootcamp.demo.demo_api.exception.ErrorCode;
import com.bootcamp.demo.demo_api.exception.UserDidNotExistException;
import com.bootcamp.demo.demo_api.model.User;
import com.bootcamp.demo.demo_api.services.UserServices;

@RestController // -> @ Controller + @ResponseBody
public class UserController implements UserOperation {

  @Autowired
  private UserServices userServices;

  @Override
  public User[] getUsers(){
    return userServices.getUsers();
  }

  @Override
  public UserEntity getUser(String id){
    Optional<UserEntity> userEntity = this.userServices.getUser(Long.valueOf(id));
    if (userEntity.isPresent())
      return userEntity.get();
    throw new UserDidNotExistException(ErrorCode.USER_NOT_FIND_EXPECTION);
  }

}
