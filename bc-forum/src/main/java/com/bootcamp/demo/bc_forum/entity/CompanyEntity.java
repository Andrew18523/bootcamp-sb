package com.bootcamp.demo.bc_forum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name ="Compaines")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CompanyEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "company_id")
  private Long id;
  private String name;
  private String catchPhrase;
  private String bs;

  @JsonIgnore
  @OneToOne
  @JoinColumn (name = "user_id" )
  private UserEntity user;
}
