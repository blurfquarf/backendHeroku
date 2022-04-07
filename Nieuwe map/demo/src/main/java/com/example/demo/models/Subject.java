package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
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
    private String title;
    private String description;

    public Subject(String n) {
        title = n;
    }

    public Subject(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Subject(String title, String description) {
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                ", title=" + title + ", description" + '\'' +
                '}';
    }

}