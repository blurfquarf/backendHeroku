package com.example.demo.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    public Subject getKeuze1() {
        return keuze1;
    }

    public void setKeuze1(Subject keuze1) {
        this.keuze1 = keuze1;
    }

    public Subject getKeuze2() {
        return keuze2;
    }

    public void setKeuze2(Subject keuze2) {
        this.keuze2 = keuze2;
    }

    public Subject getKeuze3() {
        return keuze3;
    }

    public void setKeuze3(Subject keuze3) {
        this.keuze3 = keuze3;
    }

    @ManyToOne
    @JoinColumn(name = "keuze_1_id")
    private Subject keuze1;
    @ManyToOne
    @JoinColumn(name = "keuze_2_id")
    private Subject keuze2;
    @ManyToOne
    @JoinColumn(name = "keuze_3_id")
    private Subject keuze3;


    @ManyToOne
    @JoinColumn(name = "opleiding_id")
    private Opleiding opleiding;

    public void setOpleiding(Opleiding opleiding){
        this.opleiding = opleiding;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new List<Role>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Role> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Role role) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Role> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Role> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Role get(int index) {
            return null;
        }

        @Override
        public Role set(int index, Role element) {
            return null;
        }

        @Override
        public void add(int index, Role element) {

        }

        @Override
        public Role remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Role> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Role> listIterator(int index) {
            return null;
        }

        @Override
        public List<Role> subList(int fromIndex, int toIndex) {
            return null;
        }
    };



    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject s){
        this.subject = s;
    }

    public User() {
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}
