package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.BookOperation;
import com.bootcamp.demo.demo_sb_calculator.model.Bag;
import com.bootcamp.demo.demo_sb_calculator.model.Book;
import com.bootcamp.demo.demo_sb_calculator.model.Bag.Color;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller 
// @Controller annotation -> Before server start complete, ask Spring to create a new BookController() object.
// The created object will be store in Spring Context (not the heap memory, seperate memory location)
// All this kind of object, we call it as "bean" 
// This bean must be created before server start completed.
// Implication: If the bean fail to create, server start fail. 
// If bean not exists, server start fail. No API services.
@ResponseBody
public class BookController implements BookOperation {

  public Book getBook(int id, double price){
    return new Book (id,price,null);
  }
  // http://localhost:8080/book?id=1&price=10.3

  public Book getBook2(int id, double price){
    return new Book (id,price,null);
  }


  public List<Book> getBook(){
    return List.of(new Book(1,10,null), new Book(2,12,null));
  }
  

  public Set<Book> getBookSet(){
    //error :return Set.of(new Book(1,10), new Book(2,12), new Book(2,12));
    return Set.of(new Book(1,10,null), new Book(2,12,null));
  }


  public Map<Integer, Book> getBookMap(){
    // Map<Integer, Book> map =  new HashMap<>();
    // map.put(1,new Book(1,10));
    // map.put(3,new Book(2,12));
    // return map;
    return Map.of(1,new Book(1,10,null),3,new Book(4,12,null));
  }


  public Book[] getBookArray(){
    return new Book[] {new Book(1,10,null), new Book(2,12,null)};
  }

  public Bag getBag(){
    return Bag.builder()
                .books_List(List.of(new Book(1,10,List.of("abc","def")), new Book(2,12,List.of("hij"))))
                .color(Color.RED)
                .build();
  }
  
  
}
