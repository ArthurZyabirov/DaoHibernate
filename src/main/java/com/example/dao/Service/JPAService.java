package com.example.dao.Service;

import com.example.dao.Entity.Person;
import com.example.dao.Repository.PeopleCustomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAService {

    private PeopleCustomRepository repository;

    public JPAService(PeopleCustomRepository repository) {
        this.repository = repository;
    }
    public List getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List getPersonsByAge(int age) {
        return repository.getPersonsByAge(age);
    }

    public Optional<Person> getPersonsByData(String name, String surname) {
        return repository.getPersonsByData(name, surname);
    }
}
