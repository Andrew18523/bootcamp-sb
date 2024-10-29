package com.bootcamp.demo.demo_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
  
}
