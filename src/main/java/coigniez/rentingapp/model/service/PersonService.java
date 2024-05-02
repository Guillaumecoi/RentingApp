package coigniez.rentingapp.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import coigniez.rentingapp.model.entity.Person;
import coigniez.rentingapp.model.repository.PersonRepository;

@Service
public class PersonService implements CrudListener<Person> {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findByNameContainingIgnoreCase(String name) {
        Set<Person> persons = new HashSet<>(personRepository.findByFirstNameContainingIgnoreCase(name));
        persons.addAll(personRepository.findByLastNameContainingIgnoreCase(name));
        return List.copyOf(persons);
    }
    
}
