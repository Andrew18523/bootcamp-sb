package com.bootcamp.demo.demo_restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.demo_restapi.model.dto.GovUserDto;
import com.bootcamp.demo.demo_restapi.util.GeneralResponse;

public interface GovUserOperation {

  @GetMapping(value = "/gov/db/user/{id}")
  GeneralResponse<GovUserDto> getUsersFromDBById(@PathVariable Long id);
}
