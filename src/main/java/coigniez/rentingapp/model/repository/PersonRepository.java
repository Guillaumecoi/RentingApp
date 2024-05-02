package coigniez.rentingapp.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import coigniez.rentingapp.model.entity.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
    List<Person> findByFirstNameContainingIgnoreCase(String name);
    List<Person> findByLastNameContainingIgnoreCase(String name);
}
