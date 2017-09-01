package org.home.spring.reactive.demo.repositories;

import org.home.spring.reactive.demo.models.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findByName(String name);
}
