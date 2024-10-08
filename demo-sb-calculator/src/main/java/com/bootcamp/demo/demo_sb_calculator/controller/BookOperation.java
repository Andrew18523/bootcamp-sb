package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_sb_calculator.model.Bag;
import com.bootcamp.demo.demo_sb_calculator.model.Book;

public interface BookOperation {
  @GetMapping(value="/book/{id}/{price}")
  public Book getBook(@PathVariable int id, @PathVariable double price);
  
  // http://localhost:8080/book?id=1&price=10.3
  @GetMapping(value="/books")
  public Book getBook2(@RequestParam int id, @RequestParam double price);

  @GetMapping(value="/booklist")
  public List<Book> getBook();
  
  @GetMapping(value="/bookset")
  public Set<Book> getBookSet();

  @GetMapping(value="/bookmap")
  public Map<Integer, Book> getBookMap();

  @GetMapping(value="/bookarray")
  public Book[] getBookArray();

  @GetMapping(value= "/bag")
  public Bag getBag();
}
