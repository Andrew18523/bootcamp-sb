package com.bootcamp.demo.demo_api_practice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "t_users")
@Getter
@Builder
@AllArgsConstructor
public class UserEntity {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
  private Long id;
  private String name;
  private String username;
  @Column(name = "useremail") // customized column name
  private String email;
  private String phone;
  private String website;
  private String dummy;
}
