package com.bootcamp.demo.tutorial_sbcalculator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class APIResponse {
  private String x;
  private String y;
  private String operation;
  private String result;

}
