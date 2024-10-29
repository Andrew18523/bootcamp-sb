package com.bootcamp.demo.demo_restapi.services;


import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;

public interface UserServices {
  /**
   * Get user data from jsonplaceholder.typicode.com/users
   */
  UserDto[] getUsers();

    /**
   * Get user data from DB
   */

   List<UserDto> getUsersFromWebsite();

  Optional <UserEntity> getUsersFromDB(Long id);

  void deleteById(Long id);

  UserEntity getUserByUsername(String username);

}
