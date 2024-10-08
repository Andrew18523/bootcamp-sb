package com.bootcamp.demo.demo_sb_calculator.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_calculator.model.Database;

@Service // Component -> Bean
public class DatabaseService {

  public String addString(String newString){
    return Database.addString(newString);
  }
  
  public String getString(int index){
    return Database.getString(index);
  }
  public String[] getAllString(){
    return Database.getAllString();
  }

  public int getSize(){
    return Database.getSize();
  }

}
