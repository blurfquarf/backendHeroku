package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public void addNewSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long studentId) {
        boolean exists = subjectRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("subject with id " + studentId +
                    " does not exist");
        }
        subjectRepository.deleteById(studentId);
    }

    public void changePromotor(String subjectName, String mail) {
        Subject s = subjectRepository.findByName(subjectName);
        s.setPromotor(userRepository.findByEmail(mail));
    }

    public void setApproved(String subjectName) {
        Subject s = subjectRepository.findByName(subjectName);
        s.setApproved();
    }


}
