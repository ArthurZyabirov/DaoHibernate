package com.example.dao.Repository;

import com.example.dao.Entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeopleCustomRepository {

    private PersonRepository personRepository;

    public PeopleCustomRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List getPersonsByCity(String city) {
        return personRepository.findByCity(city);
    }
    public List getPersonsByAge(int age) {
        return personRepository.findByPersonIdAgeLessThan(age);
    }

    public Optional<Person> getPersonsByData(String name, String surname) {
        return personRepository.findByPersonIdNameAAndPersonIdSurname(name, surname);
    }
}
