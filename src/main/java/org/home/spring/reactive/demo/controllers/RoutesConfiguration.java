package org.home.spring.reactive.demo.controllers;

import org.home.spring.reactive.demo.models.Person;
import org.home.spring.reactive.demo.repositories.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouterFunction<?> routes(PersonRepository personRepository) {
        return nest(path("/person"),

          route(RequestPredicates.GET("/{id}"),
            request -> ok().body(personRepository.findById(request.pathVariable("id")), Person.class))

            .andRoute(method(HttpMethod.POST),
              request -> {
                personRepository.insert(request.bodyToMono(Person.class)).subscribe();
            return ok().build();
        })
        );
    }
}
