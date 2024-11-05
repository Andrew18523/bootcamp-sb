package com.bootcamp.demo.bc_forum.services;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.dto.CommentPlaceHolder;

public interface CommentServices {
  

  List<CommentPlaceHolder> getComments();

  List<CommentPlaceHolder> getRawComments();
}
