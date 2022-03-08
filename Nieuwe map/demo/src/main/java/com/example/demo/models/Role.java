package com.example.demo.models;

import javax.persistence.*;
import java.util.*;


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<Person> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
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

    public void setPrivileges(Collection<Privilege> privil) {
        privileges = privil;
    }
}