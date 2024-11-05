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
@Table (name="Geos")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class GeoEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "geo_id")
  private Long id;
  private String lat;
  private String lng;

  @JsonIgnore
  @OneToOne
  @JoinColumn (name = "address_id" )
  private AddressEntity address;
}
