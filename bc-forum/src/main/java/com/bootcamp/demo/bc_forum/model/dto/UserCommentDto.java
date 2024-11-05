package com.bootcamp.demo.bc_forum.model.dto;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.demo.bc_forum.entity.AddressEntity;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserCommentDto {
  private Long id;
  private String username;
  
  @Builder.Default
  private List<CommentDto> comments = new ArrayList<>();
}
