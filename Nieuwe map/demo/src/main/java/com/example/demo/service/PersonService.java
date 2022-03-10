package com.example.demo.service;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.transfers.PersonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000")
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        personRepository.save(person);
    }


    public void deletePerson(Long personId) {
        boolean exists = personRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("student with id " + personId +
                    " does not exist");
        }
        personRepository.deleteById(personId);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    //iedereen registreert eerst als default persoon en masterproefcoordinator kan dan role geven
    @Override
    public Person registerNewAccount(PersonTransfer accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress:" + accountDto.getEmail());
        }
        Person user = new Person();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());

        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        user.setEmail(accountDto.getEmail());
        user.setRole(new Role(Integer.valueOf(1), user));
        return repository.save(user);
    }



}