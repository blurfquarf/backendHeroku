package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Subject> getSubject(){
        return subjectService.getSubjects();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewSubject(@RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping("{subjectId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
    }
}
