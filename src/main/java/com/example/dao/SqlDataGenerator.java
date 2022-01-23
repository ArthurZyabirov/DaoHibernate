package com.example.dao;

import com.example.dao.Entity.Person;
import com.example.dao.Entity.PersonId;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SqlDataGenerator implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Petya", "Kolya", "Vasya" ,"Dima");
        var cities = List.of("Moscow", "Piter", "Vladivostok", "Kazan");
        var surnames = List.of("Petrov", "Vasilev", "Kokorin");
        var random = new Random();

        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .personId(PersonId.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(40))
                                    .build())
                            .phoneNumber(28889977)
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();

                    entityManager.persist(person);
                });

    }
}
