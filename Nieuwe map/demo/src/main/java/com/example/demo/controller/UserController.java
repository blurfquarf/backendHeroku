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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<User> getPersons(){
        return userService.getPersons();
    }


    //om te testen, posten naar api/v1/person/register ==> wat in postmapping zit, wordt achter de requestmapping gepopt
   /*
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/register")
    public void registerNewPerson(@RequestBody User user) throws EmailExists {
        userService.registerNewAccount(user);
    }
*/

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void addNewPerson(@RequestBody User user) throws EmailExists {
        userService.addNewPerson(user);
    }

/*
    @DeleteMapping("{personId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteStudent(@PathVariable("personId") Long personId){
        userService.deletePerson(personId);
    }
    */

}
