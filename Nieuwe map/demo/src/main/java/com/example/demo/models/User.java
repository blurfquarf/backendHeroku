package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@CrossOrigin(origins = "http://localhost:3000")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    //@Column(name="email")
    private String email;

    //@Column(name="password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "role_users", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
/*

    @ManyToMany//(mappedBy = "users")
    private Collection<Role> roles = new ArrayList<Role>();

    /*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    private List<Role> roles;
*/


    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstName + " " + lastName + '\'' +
                '}';
    }

    public void setRoles(final List<Role> r) {
        this.roles = r;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    /*
    public Collection<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Collection<Subject> subject) {
        this.subject = subject;
    }
    */

}