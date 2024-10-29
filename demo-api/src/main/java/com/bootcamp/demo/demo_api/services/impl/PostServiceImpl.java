package com.bootcamp.demo.demo_api.services.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_api.infra.ApiUtil;
import com.bootcamp.demo.demo_api.infra.Scheme;
import com.bootcamp.demo.demo_api.model.Mapper;
import com.bootcamp.demo.demo_api.model.Post;
import com.bootcamp.demo.demo_api.repository.PostRepository;
import com.bootcamp.demo.demo_api.services.PostService;

@Service
public class PostServiceImpl implements PostService {
  
  @Value("${api.endpoint.post}")
  String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ApiUtil apiUtil;
  
  @Autowired
  private Mapper mapper;

  public Post[] getPosts(){
    Post[] post = restTemplate.getForObject(apiUtil.getUrl(Scheme.HTTPS, postEndpoint), Post[].class);

    Arrays.asList(post).stream().forEach(posts->{
      postRepository.save(Mapper.postMap(posts));
    });
    return post;
  }
}
