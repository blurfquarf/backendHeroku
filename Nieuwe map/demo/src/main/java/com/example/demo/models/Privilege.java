package com.example.demo.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
/*
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
*/
    public Privilege() {
    }

    public Privilege(final String name) {
        this.name = name;
    }
}