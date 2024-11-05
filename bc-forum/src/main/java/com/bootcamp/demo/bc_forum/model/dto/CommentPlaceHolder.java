package com.bootcamp.demo.bc_forum.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Setter
public class CommentPlaceHolder {
  private Long id;
  private Long postId;
  private String name;
  private String email;
  private String body;
}
