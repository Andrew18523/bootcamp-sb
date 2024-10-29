package com.bootcamp.demo.demo_api_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.demo_api_practice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
