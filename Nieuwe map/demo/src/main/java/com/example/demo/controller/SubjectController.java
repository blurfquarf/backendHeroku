package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @CrossOrigin(origins = "https://localhost:3000")
    @GetMapping
    public List<Subject> getSubject(){
        return subjectService.getSubjects();
    }








    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    @PostMapping
    public void registerNewSubject(@Valid @RequestBody Subject subject){
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping("{subjectId}")
    @CrossOrigin(origins = "https://localhost:3000")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
    }

    @PutMapping("/pro")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void promotor(@RequestParam String subjectName, @RequestParam String mail){
        subjectService.changePromotor(subjectName, mail);
    }

    @PutMapping("/copro")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void copromotoren(@RequestParam List<String> copromail, @RequestParam String subjectName){
        subjectService.setCopros(copromail, subjectName);
    }


    @PutMapping("/approved")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void approved(@RequestParam String subjectName){
        subjectService.setApproved(subjectName);
    }

    @PutMapping("/campus")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void campus(@RequestParam List<String> campussen, @RequestParam String subject){
        subjectService.setCampus(campussen, subject);
    }

    @PutMapping("/reedsgoedgekeurd")
    @CrossOrigin(origins = "https://localhost:3000", allowedHeaders = "*")
    public void reedsGGK(@RequestParam String subjectName){
        subjectService.setRGGK(subjectName);
    }




}
