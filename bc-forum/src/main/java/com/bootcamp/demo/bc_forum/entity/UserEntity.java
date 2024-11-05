package com.bootcamp.demo.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA help create table if not exists
@Table(name = "Users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;
  private String name;
  private String username;
  @Column(name = "user_email")
  private String email;
  private String phone;
  private String website;

  @OneToOne
  (mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE}
      ,fetch = FetchType.LAZY)
  private AddressEntity addressEntity;

  @OneToOne
  (mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE}
      ,fetch = FetchType.LAZY)
  private CompanyEntity companyEntity;

  @Builder.Default
  @OneToMany
  (mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE}
      ,fetch = FetchType.LAZY)
  private List<PostEntity> postEntity = new ArrayList<>();

}
