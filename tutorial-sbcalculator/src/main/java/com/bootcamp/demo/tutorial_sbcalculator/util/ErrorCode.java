package com.bootcamp.demo.tutorial_sbcalculator.util;

import lombok.Getter;

@Getter
public enum ErrorCode {
  INVALID_INPUT("0","Invalid Input"),
  INVALID_OPERATOR("1", "Invaild Operator"),
  CANNOT_DIVIDE_ZERO("2", "Cannot Divide Zero"),
  ERROR("9","UNKNOWN ERROR")
  ;

  private String code;
  private String message;

  private ErrorCode (String code, String message){
    this.code = code;
    this.message = message;
  }
}
