package com.bootcamp.demo.demo_sb_calculator.model;

import java.util.Arrays;
import java.util.List;
import lombok.Data;

@Data
public class Database {
  private static String[] strings = new String[] {"abc","def","ijk"};
  
  public static String getString(int index){
    if (index > strings.length-1){
      return "Invalid Index " + index +" out of bounds for length "+strings.length;
    }
    if (index<0){
      return "Index <0";
    }
    return strings[index];
  }

  public static String addString(String newString){
    String[] newArray = Arrays.copyOf(strings,strings.length+1);
    newArray[newArray.length-1] = newString;
    strings = newArray;
    return newString;
  }

  public static String[] getAllString(){
    return strings;
  }
  public static int getSize(){
    return strings.length;
  }
}
