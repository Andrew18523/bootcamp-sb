package com.bootcamp.demo.bc_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
  
}
