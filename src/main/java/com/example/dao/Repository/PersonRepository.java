package com.example.dao.Repository;

import com.example.dao.Entity.Person;
import com.example.dao.Entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCity(String city);

    List<Person> findByPersonIdAgeLessThan(int age);

    Optional<Person> findByPersonIdNameAAndPersonIdSurname(String name, String surname);

}
