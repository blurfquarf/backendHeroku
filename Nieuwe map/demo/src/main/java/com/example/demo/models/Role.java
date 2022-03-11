package com.example.demo.models;

import javax.persistence.*;
import java.util.*;


@Entity
@Table
public class Role {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<Person> users;

    @ManyToMany
    @JoinTable(
            name = "role_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role(){
    }

    public Role(String name){
        this.name = name;
    }

    public Collection<? extends Privilege> getPrivileges() {
        return privileges;
    }

    public String getName() {
        return name;
    }

    public void setPrivileges(final Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}