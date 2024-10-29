package com.bootcamp.demo.tutorial_sbcalculator.exception;

public class InvalidInputException extends IllegalArgumentException {
  
  private String messgae;

  public InvalidInputException (String message){
    this.messgae = message;
  }
}
