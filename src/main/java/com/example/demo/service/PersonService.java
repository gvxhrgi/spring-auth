package com.example.demo.service;


import com.example.demo.model.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    public List<String> filterPersons(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() > 20)
                .filter(p -> !p.getName().toLowerCase().startsWith("a"))
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}