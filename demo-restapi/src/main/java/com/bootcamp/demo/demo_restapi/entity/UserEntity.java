// Entity File is used to ask the Spring Boot to create table in SQL

package com.bootcamp.demo.demo_restapi.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// JPA -> JPA can operate all the SQL tools (MySQL,Postgres)
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Hibernate -> @Entity
@Entity // JPA help create table if not exists
@Table(name = "Users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
  private Long id;
  private String name;
  private String username;
  @Column(name = "user_email")
  private String email;
  private String phone;
  private String website;
  //private String dummy;

  // cascade have 3 -> ALL= REMOVE+PRESIST,MERGE
  @OneToMany(mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<PostEntity> posts;

  @OneToOne (mappedBy = "user",
      cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private CompanyEntity company;

}
