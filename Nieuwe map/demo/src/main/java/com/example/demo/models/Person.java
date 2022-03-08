package com.example.demo.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
@CrossOrigin(origins = "http://localhost:3000")
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    private long id;
    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(long id) {
        this.id = id;
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                '}';
    }
}
