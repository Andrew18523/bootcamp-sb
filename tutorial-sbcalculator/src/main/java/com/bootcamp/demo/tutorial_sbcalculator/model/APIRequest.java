package com.bootcamp.demo.tutorial_sbcalculator.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class APIRequest {
  private String x;
  private String y;
  private String operation;
}
