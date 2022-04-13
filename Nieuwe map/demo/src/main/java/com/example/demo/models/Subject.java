package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@CrossOrigin(origins = "https://localhost:3000")
public class Subject {
    @Id
    @Column(unique = true, nullable = false)
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

    private boolean approved;
    public Subject(String n) {
        name = n;
    }


    public Subject(Long id, String name, String description, boolean approved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.approved = approved;
    }

    public Subject(String name, String description, boolean approved) {
        this.name = name;
        this.description = description;
        this.approved = approved;
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

    public boolean getApproved(){
        return approved;
    }

    public void setApproved(){
        approved = true;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title=" + name + ", description" + '\'' +
                '}';
    }

}