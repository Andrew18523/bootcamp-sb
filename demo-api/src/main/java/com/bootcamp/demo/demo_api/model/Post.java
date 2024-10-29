package com.bootcamp.demo.demo_api.model;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Post {
   private Integer Id;
   private Integer userId;
   private String title;
   @Column(length = 10000)
   private String body;
}
