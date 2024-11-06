package com.bootcamp.demo.bc_forum.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;
import com.bootcamp.demo.bc_forum.repository.CommentRepository;
import com.bootcamp.demo.bc_forum.services.CommentServices;
import com.bootcamp.demo.bc_forum.util.Mapper;
import com.bootcamp.demo.bc_forum.util.UrlManager;

@Service
public class CommentServiceImpl implements CommentServices {
  @Value("${api.url.endpoint.comment}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UrlManager urlManager;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private Mapper mapper;

  @Override
  public List<CommentPlaceHolder> getComments() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    List<CommentPlaceHolder> commentDtos = List.of(restTemplate.getForObject(url, CommentPlaceHolder[].class));
    if (commentRepository.findAll().isEmpty()){
      commentDtos.stream().forEach(commentDto->{
        commentRepository.save(mapper.map(commentDto));
      });

    }
    return commentDtos;
  }

  @Override
  public List<CommentPlaceHolder> getRawComments() {
    String url = urlManager.getUrl(endpoint);
    System.out.println("Check url = "+url);
    return List.of(restTemplate.getForObject(url, CommentPlaceHolder[].class));
  }
}
