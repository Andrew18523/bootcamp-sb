package com.bootcamp.demo.demo_restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;

// ! Hibernate
// 1. During compile time, generate class to implement this interface
// 3. Construct the corresponding Entity Java Object
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // you should able to see save() -> insert into Users value (...);
  // but missing here because Hibernate already help to write the save() findall() etc SQL command
  // 2. Implement the all the method according to the DB driver

  //save() -> insert into Users value (...) / Similiar Map.put -> create or update
  //findAll() -> select * from Users -> return List<User>
  //findById() -> select * from Users where Id= ?

  //saveAll() -> Many insert into .... given List<UserEntity>

  // select * from Users from name
  List<UserEntity> findByName(String name); 

  // select * from Users where name = ? and website = ?
  List<UserEntity> findByNameAndWebsite(String name, String website);


  // select * from Users where name = ? or website = ?
  List<UserEntity> findByNameOrWebsite(String name, String website);

  // ! JPQL
  // Syntax is similar to SQL
  // select from Entity Class
  // username -> entity's attribute
  // Support and, or, order by, Inner join, left join, avg(), max() etc ...
  @Query("SELECT e FROM UserEntity e WHERE e.username = :username")
  UserEntity findByUsername(@Param("username") String username);

  @Query(value = "SELECT e FROM UserEntity e WHERE e.username = :username ORDER BY e.website DESC")
  UserEntity findByUsernameOrderByWebsiteDesc(@Param("username") String username);

  // ! Native Query (SQL)
  // Disadvantages: Product specific
  // username -> column name (if column not found, SQL Exception)
  @Query(value = "SELECT * FROM Users e WHERE e.username = :username",
      nativeQuery = true)
  UserEntity findByUsername2(@Param("username") String username);

  // ! For all write operations, use @Modifying
  @Modifying
  @Query(value = "UPDATE Users SET user_email = :userEmail WHERE id = :id", nativeQuery = true)
  int updateUserEmail(@Param("userEmail") String userEmail, @Param("id") Long id);
}

