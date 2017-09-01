# Spring Boot Webflux Reactive Mongo

This is a sample application that shows how to build a web application using
 - Spring Boot 2
 - Spring Webflux
 - Spring Reactive Data MongoDb
 - Spring Security Reactive Webflux
 
 
Please see the following pages for more details
  
  - Spring Web Reactive <br/><a>http://docs.spring.io/spring-framework/docs/5.0.0.M1/spring-framework-reference/html/web-reactive.html</a>
  - Spring Data Reactive <br/><a>https://spring.io/blog/2016/11/28/going-reactive-with-spring-data</a>
  - Spring Functional Web Framework <br/><a>https://spring.io/blog/2016/09/22/new-in-spring-5-functional-web-framework</a>

## Running

In application.yml, configure appropriate values such as:

    spring.data.mongodb:
        host: 192.168.11.20
        database: mydb
        
Load the data into mongodb by first prepare a js file:

    db.person.insert({"name": "John Doe", "age": 39})
    db.person.insert({"name": "Jack Jones", "age": 29})
    db.person.insert({"name": "Joe Sanfu", "age": 25})

Then run command like:

    mango 192.168.11.20:27017/mydb --quiet load_data.js
        
Then your are ready to launch the application:

    gradle bootRun

Finally, go to http://localhost:8080/person and you should see three person json objects.
