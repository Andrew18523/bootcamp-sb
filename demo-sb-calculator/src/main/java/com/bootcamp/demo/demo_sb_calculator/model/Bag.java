package com.bootcamp.demo.demo_sb_calculator.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Serialization: Java object (array, map, object) -> JSON Pain Text
// To do Serialization so @Getter is important for getting the value from object to JSON Pain Text

//@Data
@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bag {
  @JsonProperty (value = "books")
  private List<Book> books_List;
  private Color color;

  public static enum Color{
    RED,YELLO,BLUE,;
  }
}
