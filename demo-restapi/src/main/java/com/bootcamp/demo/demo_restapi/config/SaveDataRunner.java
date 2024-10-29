package com.bootcamp.demo.demo_restapi.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_restapi.entity.CompanyEntity;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.mapper.JPHmapper;
import com.bootcamp.demo.demo_restapi.model.dto.PostDto;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.services.PostServices;
import com.bootcamp.demo.demo_restapi.services.UserServices;

@Component
public class SaveDataRunner implements CommandLineRunner {

  @Autowired
  private UserServices userServices;

  @Autowired
  private PostServices postServices;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JPHmapper jphMapper;

  @Override
  public void run(String... args) throws Exception{
    // get Users from website
    List<UserDto> users= this.userServices.getUsersFromWebsite();
    // get Posts from website
    List<PostDto> posts = this.postServices.getPosts();

    // One to Many
    List<UserEntity> userEntities = users.stream().map(u->{
      UserEntity userEntity = this.jphMapper.map(u);

      List<PostEntity> postEntities = posts.stream()
        .filter(p-> p.getUserId().equals(u.getId()))
        .map(p->{
            PostEntity postEntity = this.jphMapper.map(p);
          postEntity.setUser(userEntity);
        return postEntity;
      })//
        .collect(Collectors.toList());

      CompanyEntity companyEntity = this.jphMapper.map(u.getCompany());
      companyEntity.setUser(userEntity);

    userEntity.setPosts(postEntities);
    userEntity.setCompany(companyEntity);
    return userEntity;
    }).collect(Collectors.toList());

    userRepository.saveAll(userEntities);
  }
}
