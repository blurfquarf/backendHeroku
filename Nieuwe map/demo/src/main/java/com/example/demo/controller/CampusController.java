package com.example.demo.controller;

import com.example.demo.models.Campus;
import com.example.demo.models.Subject;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/campus")
public class CampusController {
    private final CampusService campusService;

    @Autowired
    public CampusController(CampusService campusService) {
        this.campusService = campusService;
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping
    public List<Campus> getCampussen(){
        return campusService.getCampussen();
    }
}