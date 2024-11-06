package com.bootcamp.demo.bc_forum.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.PostPlaceHolder;
import com.bootcamp.demo.bc_forum.repository.PostRepository;
import com.bootcamp.demo.bc_forum.services.PostServices;
import com.bootcamp.demo.bc_forum.util.Mapper;
import com.bootcamp.demo.bc_forum.util.UrlManager;

@Service
public class PostServicesImpl implements PostServices {
  @Value("${api.url.endpoint.post}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UrlManager urlManager;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public List<PostPlaceHolder> getPosts() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    List<PostPlaceHolder> postDtos = List.of(restTemplate.getForObject(url, PostPlaceHolder[].class));
    if(postRepository.findAll().isEmpty()){
      postDtos.stream().forEach(postDto->{
        postRepository.save(mapper.map(postDto));
      });
    }
    return postDtos;
  }

  @Override
  public List<PostPlaceHolder> getRawPosts() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    return List.of(restTemplate.getForObject(url, PostPlaceHolder[].class));
  }
}
