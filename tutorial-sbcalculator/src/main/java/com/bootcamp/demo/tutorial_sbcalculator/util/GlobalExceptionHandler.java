package com.bootcamp.demo.tutorial_sbcalculator.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.tutorial_sbcalculator.exception.CannotDivideZeroException;
import com.bootcamp.demo.tutorial_sbcalculator.exception.InvalidInputException;
import com.bootcamp.demo.tutorial_sbcalculator.exception.InvalidOperationException;
import com.bootcamp.demo.tutorial_sbcalculator.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  // @ExceptionHandler(value = CannotDivideZeroException.class)
  // public ErrorResponse cannotDivideZeroException(){
  //   return ErrorResponse.builder()
  //           .code(ErrorCode.CANNOT_DIVIDE_ZERO.getMessage())
  //           .message(ErrorCode.CANNOT_DIVIDE_ZERO.getMessage())
  //           .build();
  // }
  // @ExceptionHandler(value =InvalidInputException.class)
  // public ErrorResponse invaildOperationException(){
  //   return ErrorResponse.builder()
  //           .code(ErrorCode.INVALID_INPUT.getMessage())
  //           .message(ErrorCode.INVALID_INPUT.getMessage())
  //           .build();
  // }

  // @ExceptionHandler(value =InvalidOperationException.class)
  // public ErrorResponse invalidOperationException(){
  //   return ErrorResponse.builder()
  //           .code(ErrorCode.INVALID_OPERATOR.getMessage())
  //           .message(ErrorCode.INVALID_OPERATOR.getMessage())
  //           .build();
  // }

  // @ExceptionHandler(value = Exception.class)
  // public ErrorResponse Exception(){
  //   return ErrorResponse.builder()
  //           .code(ErrorCode.ERROR.getMessage())
  //           .message(ErrorCode.ERROR.getMessage())
  //           .build();
  // }
}
