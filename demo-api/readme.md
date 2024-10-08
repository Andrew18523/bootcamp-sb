# Step of create Spring-boot project

1. delete .vmvn floder
2. change folder to application.yml
2.1 you can define your port number: defalut 8080
3. create Folder under <groupId>com.bootcamp.demo</groupId> and 	<artifactId>demo-api</artifactId>
com.bootcamp.demo/demo-api
3.1 Create: Controller, Service, Config, infra, model

4. Call third party API -> https://jsonplaceholder.typicode.com/users -> breakdown the API path in application.yml
4.1 In application.yml
easy:
  domain: jasonplaceholder.type.com
  endpoint:
    user: /users

example 2: https:openirce.com/en/hongkong/restaurants?conditionId=10039/tmReservation=true
  domain: openirce.com
  lan: en (or zh)
  location: hongkong
  restaurants: restaurants

  If you need to fetch API facing @RequestParam -> you can use Map to handle it in 
  restTemplate.getForObject()
5. make sure you have dependenct: spring web, becasue we need RestTemplate
to fetch third party API

5.1 restTemplate.getForObject
5.2 so we need to make RestTemplate be @Bean first
5.3 that why we create a config a folder to handle the @Bean
```java=
@Configuration // -> @Bean -> SpringContext -> Autowired
public class AppConfig {
  
  // Call API
  @Bean //became unique object
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
```

6. Now we can go to Services,
don't forget to add Annotation @Services
 create method to fetch api by restTemplate.getForObject()
6.1 before that, we need to use @Value from 'import.org.springframework.beans.factory.annotation.Value;'
not from lombok
6.2 use UriComponentsBuilder to merge the URL
```
  return UriComponentsBuilder.newInstance()
  .scheme(scheme.name()) //http/https
  .host(domain) //xxx.com
  .path(endpoint)
  .toUriString();
```
expected result: https://jsonplaceholder.typicode.com/users
actual result: xxxxxxxxxx.xxx

use
```java=
  return UriComponentsBuilder.newInstance()
  .scheme(scheme.name()) //http/https
  .host(domain) //xxx.com
  .path(endpoint)
  .bulild(false) !!!!!
  .toUriString();
```

7. Go to Controller layer
add anotation @RestController -> include @Controller and @ResponseBody
7.1 define your own Restful API:
A. Get
B. Post
C. Put
D. Patch
E. Delete
7.2 3 type of Inputparam:
A. @PathVariable ->{endpoint}/pathA/pathB
B. @RequestPAram -> "?param1=xxxx&param2=yy"
C. @RequestBody -> Input Json, so we need to create an Object in Java by Class
example in Postman:
```
{
  "name":
  "email":
  "phone":
}
```
step to input Json in postman: Body ->raw ->JSON

```
@GETTER
@SETTER
public class UserForm{
  String name;
  String email:
  String phone:
}
```

# make sure your server is runnign without ERROR
when you server can not run success
check keyword:'cause by'

## don't forget the @RestController, @Services annotation in these 2 layer
if you need to @Autowired, make sure it is @Bean -> @Controller/@Services
/ @Repository/ @Configuration/ @Component 
in class level

if you need ot make an Object to be Bean, @Bean: example: RestTemplate




