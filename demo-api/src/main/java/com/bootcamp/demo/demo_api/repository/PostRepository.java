package com.bootcamp.demo.demo_api.repository;

import com.bootcamp.demo.demo_api.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long>{
  
}
