package com.bootcamp.demo.demo_restapi.controller.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_restapi.bootcamp.BusinessException;
import com.bootcamp.demo.demo_restapi.bootcamp.ErrorCode;
import com.bootcamp.demo.demo_restapi.bootcamp.GeneralResponse;
import com.bootcamp.demo.demo_restapi.bootcamp.SysCode;
import com.bootcamp.demo.demo_restapi.controller.GovUserOperation;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.mapper.GovMapper;
import com.bootcamp.demo.demo_restapi.model.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.services.UserServices;

@RestController
public class GovUserController implements GovUserOperation {
  
  @Autowired
  private UserServices userService;

  @Override
  public GeneralResponse<GovUserDto> getUsersFromDBById(Long id){
    Optional<UserEntity> optUserEntity = this.userService.getUsersFromDB(id);
    if (optUserEntity.isPresent()){
      UserEntity userEntity = optUserEntity.get();
      GovUserDto govUserDto = GovMapper.map(userEntity);

      return GeneralResponse.<GovUserDto>builder() //
          .status(SysCode.OK) //
          .data(List.of(govUserDto)) //
          .build();
    }
    throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
      // return GeneralResponse.<GovUserDto>builder() //
      // .status(SysCode.FAIL) //
      // .data(List.of())
      // .build();
    //throw new BusinessException(ErrorCode.USER_ID_NOT_FOUND);
  }


}