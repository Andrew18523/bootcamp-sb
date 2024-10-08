package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface DatabaseOperation {
  // Read Operation. 寫左GetMapping，就約定左只係GET NO POST
  @GetMapping(value = "/database/strings/{index}")
  String getString(@PathVariable int index);

  //Write Operation (Create new resources)
  @PostMapping(value = "/database/strings/{newString}")
  String addString(@PathVariable String newString);
  
  @GetMapping(value = "/database/allString/")
  List<String> getAllString();

  @GetMapping(value = "/database/strings/size")
  int getSize();
}
