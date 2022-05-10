package com.example.demo.controller;

import com.example.demo.checks.EmailExists;
import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/keuze1")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void k1(@RequestParam String keuze1, @RequestParam String studentMail){
        userService.setK1(keuze1, studentMail);
    }

    @PostMapping("/keuze2")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void k2(@RequestParam String keuze2, @RequestParam String studentMail){
        userService.setK2(keuze2, studentMail);
    }

    @PostMapping("/keuze3")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void k3(@RequestParam String keuze3, @RequestParam String studentMail){
        userService.setK3(keuze3, studentMail);
    }

    @PostMapping("/keuzes")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void k123(@RequestParam String keuze1, @RequestParam String keuze2, @RequestParam String keuze3, @RequestParam String studentMail){
        userService.setK1(keuze1, studentMail);
        userService.setK2(keuze2, studentMail);
        userService.setK3(keuze3, studentMail);
    }



    //studenten per subject
    @GetMapping(value = "/studentenpersubkeuze")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Map<Integer, User> getSperSub(@RequestParam String subjectName) {
        return userService.getSperSub(subjectName);
    }

    //campusGet
    @GetMapping(value = "/campus")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Campus getCampus(@RequestParam String mail) {
        return userService.getCampus(mail);
    }

    //opleidingGet
    @GetMapping(value = "/opleiding")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public Opleiding getOpleiding(@RequestParam String mail) {
        return userService.getOpleiding(mail);
    }


    //onderwerpen horend bij coordinator
    @GetMapping(value = "/subsvoorcoord")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public List<Subject> getSubsPerCoord(@RequestParam String mail) {
        return userService.getSubsPerCoord(mail);
    }

    @PostMapping("/toewijzing")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void definitieveToewijzing(@RequestParam String subjectName, @RequestParam String studentMail){
        userService.setSubject(subjectName, studentMail);
    }


}