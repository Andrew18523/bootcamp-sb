package com.bootcamp.demo.bc_forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptioHandler {
  
  @ExceptionHandler({UserNotFoundException.class})
  @ResponseStatus (HttpStatus.NOT_FOUND)
  public ErrorResponse UserNotFoundExceptionHandler (){
    return ErrorResponse.builder()
            .code(ErrorCode.USER_NOT_FIND.getCode())
            .message(ErrorCode.USER_NOT_FIND.getMessage())
            .build();
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.NOT_FOUND) // 404
  public ErrorResponse handleException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.UNKNOWN_ERROR.getCode())//
        .message(ErrorCode.UNKNOWN_ERROR.getMessage())//
        .build();
  }


}
