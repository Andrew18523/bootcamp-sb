package com.bootcamp.demo.demo_restapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankUserDto {
  private String name;
  private String email;
  private String website;
}
