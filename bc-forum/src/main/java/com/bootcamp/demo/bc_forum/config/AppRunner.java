package com.bootcamp.demo.bc_forum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.AddressEntity;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum.entity.GeoEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;
import com.bootcamp.demo.bc_forum.model.dto.UserPlaceHolder;
import com.bootcamp.demo.bc_forum.services.CommentServices;
import com.bootcamp.demo.bc_forum.services.PostServices;
import com.bootcamp.demo.bc_forum.services.UserServices;
import com.bootcamp.demo.bc_forum.util.Mapper;

@Component
public class AppRunner implements CommandLineRunner {

  @Autowired
  private UserServices userServices;

  @Autowired
  private PostServices postServices;

  @Autowired
  private CommentServices commentServices;

  @Autowired
  private Mapper mapper;

  @Override
  public void run(String... args)throws Exception{
    System.out.println("Start Server!!!!!");
    System.out.println("Start saving  address, company ,geo, post and comment");
    List<UserPlaceHolder> userPlaceHolders =  userServices.getRawUsers();
    List<PostPlaceHolder> postPlaceHolders =  postServices.getRawPosts();
    List<CommentPlaceHolder> commentPlaceHolders = commentServices.getRawComments();

    List<UserEntity> userEntities = userPlaceHolders.stream().map(userDto->{
      UserEntity userEntity = this.mapper.map(userDto);
      AddressEntity addressEntity = this.mapper.mapToAddressEntity(userDto);
      GeoEntity geoEntity = this.mapper.mapTGeoEntity(userDto);
      CompanyEntity companyEntity = this.mapper.mapTCompanyEntity(userDto);
      
      // relationship setting for address entity and geo entity
      geoEntity.setAddress(addressEntity);
      addressEntity.setGeoEntity(geoEntity);

      // relationship setting for user entity and company entity
      addressEntity.setUser(userEntity);
      userEntity.setAddressEntity(addressEntity);

      // relationship setting for user entity and company entity
      companyEntity.setUser(userEntity);
      userEntity.setCompanyEntity(companyEntity);

      List<PostEntity> postEntities = postPlaceHolders.stream()
        .filter(postDto -> postDto.getUserId().equals(userDto.getId()))
        .map(postDto -> { 
          PostEntity postEntity = this.mapper.map(postDto);
          List<CommentEntity> commentEntities = commentPlaceHolders.stream()
            .filter(commentDto -> commentDto.getPostId().equals(postDto.getId()))
            .map(commentDto->{
              CommentEntity commentEntity = this.mapper.map(commentDto);
              commentEntity.setPosts(postEntity);
              return commentEntity;
            })
            .collect(Collectors.toList());
            postEntity.setCommentEntity(commentEntities);
            postEntity.setUser(userEntity);
          return postEntity;
        }).collect(Collectors.toList());
        userEntity.setPostEntity(postEntities);
      return userEntity;
    }).collect(Collectors.toList());

    userServices.saveAll(userEntities);
  }
}
