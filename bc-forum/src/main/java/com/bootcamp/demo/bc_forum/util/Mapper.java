package com.bootcamp.demo.bc_forum.util;

import java.util.List;
import java.util.stream.Collectors;
import javax.xml.stream.events.Comment;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.AddressEntity;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum.entity.GeoEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.CommentDto;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.UserCommentDto;
import com.bootcamp.demo.bc_forum.model.dto.UserDto;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.UserDto.AddressDto;
import com.bootcamp.demo.bc_forum.model.dto.UserDto.CompanyDto;
import com.bootcamp.demo.bc_forum.model.dto.UserDto.PostDto;
import com.bootcamp.demo.bc_forum.model.dto.UserDto.AddressDto.GeoDto;


@Component
public class Mapper {
  public UserEntity map (UserPlaceHolder userpPlaceHolder){
    return UserEntity.builder()
            .name(userpPlaceHolder.getName())
            .username(userpPlaceHolder.getUsername())
            .email(userpPlaceHolder.getEmail())
            .phone(userpPlaceHolder.getPhone())
            .website(userpPlaceHolder.getWebsite())
            .build();
  }

  public CommentEntity map (CommentPlaceHolder commentPlaceHolder){
    return CommentEntity.builder()
            .name(commentPlaceHolder.getName())
            .email(commentPlaceHolder.getEmail())
            .body(commentPlaceHolder.getBody())
            .build();
  }

  public CompanyEntity mapTCompanyEntity (UserPlaceHolder userPlaceHolder){
    return CompanyEntity.builder()
            .name(userPlaceHolder.getCompany().getName())
            .catchPhrase(userPlaceHolder.getCompany().getCatchPhrase())
            .bs(userPlaceHolder.getCompany().getBs())
            .build();
  }

  public GeoEntity mapTGeoEntity (UserPlaceHolder userPlaceHolder){
    return GeoEntity.builder()
              .lat(userPlaceHolder.getAddress().getGeo().getLat())
              .lng(userPlaceHolder.getAddress().getGeo().getLng())
              .build();
  }

  public PostEntity map (PostPlaceHolder postPlaceHolder){
    return PostEntity.builder()
            .title(postPlaceHolder.getTitle())
            .body(postPlaceHolder.getBody())
            .build();
  }

  public AddressEntity mapToAddressEntity (UserPlaceHolder userPlaceHolder){
    return AddressEntity.builder()
            .street(userPlaceHolder.getAddress().getStreet())
            .suite(userPlaceHolder.getAddress().getSuite())
            .city(userPlaceHolder.getAddress().getCity())
            .zipcode(userPlaceHolder.getAddress().getZipcode())
            .build();
  }

  public PostDto map (PostEntity postEntity){
    return PostDto.builder()
      .body(postEntity.getBody())
      .title(postEntity.getTitle())
      .build();
  }

  public CommentDto map (CommentEntity commentEntity){
    return CommentDto.builder()
      .name(commentEntity.getName())
      .body(commentEntity.getBody())
      .email(commentEntity.getEmail())
      .build();
  }

  public UserDto map (UserEntity userEntity){
    GeoDto geoDto = GeoDto.builder()
      .lat(userEntity.getAddressEntity().getGeoEntity().getLat())
      .lng(userEntity.getAddressEntity().getGeoEntity().getLng())
      .build();
    
    AddressDto addressDto = AddressDto.builder()
      .street(userEntity.getAddressEntity().getStreet())
      .suite(userEntity.getAddressEntity().getSuite())
      .city(userEntity.getAddressEntity().getCity())
      .zipcode(userEntity.getAddressEntity().getZipcode())
      .geo(geoDto)
      .build();
    
    CompanyDto companyDto = CompanyDto.builder()
      .name(userEntity.getCompanyEntity().getName())
      .catchPhrase(userEntity.getCompanyEntity().getCatchPhrase())
      .bs(userEntity.getCompanyEntity().getBs())
      .build();
    
    List<CommentDto> commentDTOs = userEntity.getPostEntity().stream()//
      .map(post -> {
        CommentDto commentDto = post.getCommentEntity().stream()//
          .map(commentEntity -> this.map(commentEntity))//
          .findFirst()//
          .get();
        return commentDto;
        })//
        .collect(Collectors.toList());

    List<PostDto> postDTOs = userEntity.getPostEntity().stream()//
        .map(postEntity -> {
          PostDto postDTO = this.map(postEntity);
          postDTO.setComments(commentDTOs);;
          return postDTO;
        })//
        .collect(Collectors.toList());

      return UserDto.builder()//
        .id(userEntity.getId())
        .name(userEntity.getName())//
        .username(userEntity.getUsername())//
        .email(userEntity.getEmail())//
        .phone(userEntity.getPhone())//
        .website(userEntity.getWebsite())//
        .company(companyDto)//
        .address(addressDto)//
        .posts(postDTOs)//
        .build();

  }

}
