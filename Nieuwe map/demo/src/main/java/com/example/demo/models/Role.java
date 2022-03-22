package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.*;


@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.MERGE)
    private Collection<User> users = new ArrayList<User>();

/*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    private List<User> users;
    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
    */

    public Role(){
    }

    public Role(String name){
        this.name = name;
    }

    /*
    public Collection<? extends Privilege> getPrivileges() {
        return privileges;
    }
*/
    public String getName() {
        return name;
    }
/*
    public void setPrivileges(final Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

     */
}