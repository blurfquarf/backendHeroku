package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<User> getPersons(){
        return userService.getPersons();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewPerson(@RequestBody User user){
        userService.addNewPerson(user);
    }

    @DeleteMapping("{personId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteStudent(@PathVariable("personId") Long personId){
        userService.deletePerson(personId);
    }
}
