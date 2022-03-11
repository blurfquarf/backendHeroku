package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }

    @DeleteMapping("{personId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteStudent(@PathVariable("personId") Long personId){
        personService.deletePerson(personId);
    }


}
