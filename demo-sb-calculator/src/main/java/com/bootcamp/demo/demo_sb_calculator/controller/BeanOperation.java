package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  @GetMapping(value = "/bean")
  List<String> getBeans();
}
