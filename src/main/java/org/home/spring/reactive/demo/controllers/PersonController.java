package org.home.spring.reactive.demo.controllers;

import org.home.spring.reactive.demo.models.Person;
import org.home.spring.reactive.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Flux<Person> index() {
        return personRepository.findAll();
    }
}
