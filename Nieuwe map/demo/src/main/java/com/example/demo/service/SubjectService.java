package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public void addNewSubject(Subject subject) {
        subjectRepository.save(subject);
    }


    public void deleteSubject(Long studentId) {
        boolean exists = subjectRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("subject with id " + studentId +
                    " does not exist");
        }
        subjectRepository.deleteById(studentId);
    }

}
