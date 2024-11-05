package com.bootcamp.demo.bc_forum.exception;


public enum ErrorCode {
  USER_NOT_FIND("1","User not found."),
  INVALID_INPUT("2","Invalid Input."),
  UNKNOWN_ERROR("999","Unknown Error"),
  ;

  private String code;
  private String message;

  private ErrorCode (String code, String message){
    this.code = code;
    this.message = message;
  }

  public String getCode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }
}
