package com.bootcamp.demo.bc_forum.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Setter
public class PostPlaceHolder {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}

