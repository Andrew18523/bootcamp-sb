package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.model.dto.BankUserDto;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;
import com.bootcamp.demo.demo_restapi.services.UserServices;
import com.bootcamp.demo.demo_restapi.bootcamp.BusinessException;
import com.bootcamp.demo.demo_restapi.bootcamp.ErrorCode;
import com.bootcamp.demo.demo_restapi.bootcamp.GeneralResponse;
import com.bootcamp.demo.demo_restapi.bootcamp.SysCode;
import com.bootcamp.demo.demo_restapi.controller.BankUserOperation;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.mapper.BankMapper;

@RestController
public class BankUserController implements BankUserOperation {

  @Autowired
  private UserServices userService;

  @Override
  public UserDto[] getUsers() {
    return this.userService.getUsers();
  }


  @Override
  public UserEntity getUsersFromDBById(Long id){
    Optional<UserEntity> userEntity = this.userService.getUsersFromDB(id);
    if (userEntity.isPresent()){
      return userEntity.get();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }

  @Override
  public String deleteUserFromDBById(Long id){
    Optional<UserEntity> userEntity = this.userService.getUsersFromDB(id);
    if (userEntity.isPresent()){
      this.userService.deleteById(id);
      return "User Deleted";
    } else {
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
    }
  }

    @Override
    public GeneralResponse<BankUserDto> getUserByUsername(String username) {
    UserEntity userEntity = this.userService.getUserByUsername(username);

    BankUserDto bankUserDto = BankMapper.map(userEntity);

    return GeneralResponse.<BankUserDto>builder() //
        .status(SysCode.OK) //
        .data(List.of(bankUserDto)) //
        .build();
  }
}
