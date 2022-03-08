package com.example.demo.service;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }


    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("student with id " + personId +
                    " does not exist");
        }
        personRepository.deleteById(personId);
    }

}