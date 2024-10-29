package com.bootcamp.demo.demo_api_practice.contorller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_api_practice.model.User;

public interface UserOperation {
  
  @GetMapping("/users")
  List<User> getUsers();
}
