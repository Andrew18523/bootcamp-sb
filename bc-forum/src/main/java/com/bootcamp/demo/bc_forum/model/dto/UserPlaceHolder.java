package com.bootcamp.demo.bc_forum.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class UserPlaceHolder {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  @ToString
  public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @ToString
    public class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @ToString
  public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
