package com.bootcamp.demo.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name ="Posts")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Column(length = 10000)
  private String body;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id" )
  private UserEntity user;

  @Builder.Default
  @OneToMany
  (mappedBy = "posts",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE}
      ,fetch = FetchType.LAZY)
  private List<CommentEntity> commentEntity = new ArrayList<>();

}
