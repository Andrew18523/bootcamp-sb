package com.bootcamp.demo.demo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.demo_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
  
}
