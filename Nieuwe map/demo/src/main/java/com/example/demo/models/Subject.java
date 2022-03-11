package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )

    private Long id;
    private String name;
    private String description;

    public Subject(String n) {
        name = n;
    }

    public Subject(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name=" + name + ", description" + '\'' +
                '}';
    }

}