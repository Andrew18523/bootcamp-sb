package com.bootcamp.demo.tutorial_sbcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
  private String code;
  private String message;
}
