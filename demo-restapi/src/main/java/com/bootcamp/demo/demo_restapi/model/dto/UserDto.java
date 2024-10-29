package com.bootcamp.demo.demo_restapi.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* Why we need @Getter only
 * because we only do the Serializtion (JSon-> Java Object)
 * if we do Deserializtion then Setter is needed
 */
@Getter
@ToString
@Setter
@NoArgsConstructor
public class UserDto {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDto address;
  private String phone;
  private String website;
  private CompanyDto company;

  @Getter
  @ToString
  public class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;

    @Getter
    @ToString
    public class GeoDto {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @ToString
  public class CompanyDto {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
