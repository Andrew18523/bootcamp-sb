package com.bootcamp.demo.bc_forum.exception;

public class InvalidInputException extends RuntimeException {
  
  public InvalidInputException (String message){
    super(message);
  }
}
