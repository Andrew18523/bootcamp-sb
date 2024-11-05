package com.bootcamp.demo.bc_forum.model.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDto address;
  private String phone;
  private String website;
  private CompanyDto company;
  private List<PostDto> posts = new ArrayList<>();


  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  @Getter
  @ToString
  @Builder
  @JsonIgnoreProperties
  public static class PostDto {
    private Long id;
    private String title;
    private String body;
    private List<CommentDto> comments = new ArrayList<>();
  } 

  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  @Getter
  @ToString
  @Builder
    public static class AddressDto {
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @ToString
    @Builder
    public static class GeoDto {
      private Long id;
      private String lat;
      private String lng;
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  @Getter
  @ToString
  @Builder
  public static class CompanyDto {
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
