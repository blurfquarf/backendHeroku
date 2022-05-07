package com.example.demo.controller;

import com.example.demo.checks.EmailExists;
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


/*
    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping
    public List<User> getPersons(){
        return userService.getPersons();
    }*/

    @CrossOrigin(origins = "https://localhost:3000")
    @PostMapping
    public void addNewPerson(@RequestBody User user) throws EmailExists {
        userService.addNewPerson(user);
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping
    public List<User> getPromotoren() {
        return userService.getPros();
    }
}