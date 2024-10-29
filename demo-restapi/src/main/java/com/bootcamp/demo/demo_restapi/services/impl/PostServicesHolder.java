package com.bootcamp.demo.demo_restapi.services.impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_restapi.bootcamp.UrlManager;
import com.bootcamp.demo.demo_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_restapi.mapper.JPHmapper;
import com.bootcamp.demo.demo_restapi.model.dto.PostDto;
import com.bootcamp.demo.demo_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_restapi.services.PostServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostServicesHolder implements PostServices {
  
    // Field Injection
  @Value("${api.url.domain}")
  private String domain;

  @Value("${api.url.endpoint.post}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private JPHmapper jphMapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Override
  public List <PostDto> getPosts(){
    String url = UrlManager.builder() //
      .domain(this.domain) //
      .endpoint(this.endpoint) //
      .build() //
      .toUriString();
    
    System.out.println("Check url=" + url);
    PostDto[] postDtos = this.restTemplate.getForObject(url, PostDto[].class);
    return Arrays.asList(postDtos);
    }

  @Override
  public List<PostEntity> getPostsFromDB() throws JsonProcessingException{
    String json = this.redisTemplate.opsForValue().get("jph-posts");
    if (json == null){
      List<PostEntity> postEntities = this.postRepository.findAll();
      String jsonToWrite = this.objectMapper.writeValueAsString(postEntities);
      this.redisTemplate.opsForValue().set("jph-posts", jsonToWrite, Duration.ofMinutes(15));
      return postEntities;
    }
    return Arrays.asList(this.objectMapper.readValue(json, PostEntity[].class));
  }
}
