package com.bootcamp.demo.demo_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler (UserDidNotExistException.class)
  public ErrorResponse userDidNotExistExceptErrorHandler (){
    return ErrorResponse.builder()
            .code(ErrorCode.USER_NOT_FIND_EXPECTION.getCode())
            .message(ErrorCode.USER_NOT_FIND_EXPECTION.getMessage())
            .build();
  }
}
