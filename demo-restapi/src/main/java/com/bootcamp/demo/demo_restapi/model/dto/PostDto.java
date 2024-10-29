package com.bootcamp.demo.demo_restapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Setter
public class PostDto {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
