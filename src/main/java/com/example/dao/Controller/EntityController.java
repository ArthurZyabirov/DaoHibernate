package com.example.dao.Controller;

import com.example.dao.Entity.Person;
import com.example.dao.Service.JPAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class EntityController {

    private final JPAService jpaService;

    public EntityController(JPAService jpaService) {
        this.jpaService = jpaService;

    }
    @GetMapping("/persons/by-city")
    public List getPersonsByCity(String city) {
        var resultList = jpaService.getPersonsByCity(city);
        System.out.println("В городе " + city + " живут клиенты:");
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-age")
    public List getPersonsByAge(int age) {
        var resultList = jpaService.getPersonsByAge(age);
        System.out.printf("Клиенты младше %s лет:\n", age);
        resultList.forEach(System.out::println);
        return resultList;
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonsByData(String name, String surname) {
        var person = jpaService.getPersonsByData(name, surname);
        System.out.printf("Клиент с именем  %s и фамилией %s:\n", person.toString());
        return person;
    }

}
