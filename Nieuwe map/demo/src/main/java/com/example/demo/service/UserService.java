package com.example.demo.service;

import com.example.demo.checks.EmailExists;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.example.demo.transfers.PersonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository RoleRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    public List<User> getPersons(){
        return userRepository.findAll();
    }

    public void addNewPerson(User user) throws EmailExists {

        if (emailExist(user.getEmail())) {
            throw new EmailExists(
                    "There is an account with that email adress:" + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public void deletePerson(Long personId) {
        boolean exists = userRepository.existsById(personId);
        if(!exists){
            throw new IllegalStateException("student with id " + personId +
                    " does not exist");
        }
        userRepository.deleteById(personId);
    }

    //iedereen registreert eerst als default persoon en masterproefcoordinator kan dan role gevenl
    //@Override

    /*
    public User registerNewAccount(PersonTransfer accountDto) throws EmailExists {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExists(
                    "There is an account with that email adress:" + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        //user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }
     */


    private boolean emailExist(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    //@Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }


    /*public void deleteUser(final Person user) {
        final VerificationToken verificationToken = tokenRepository.findByUser(user);

        if (verificationToken != null) {
            tokenRepository.delete(verificationToken);
        }

        final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);

        if (passwordToken != null) {
            passwordTokenRepository.delete(passwordToken);
        }

        personRepository.delete(user);
    }*/

    public void createVerificationTokenForUser(final User user, final String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
        vToken.updateToken(UUID.randomUUID()
                .toString());
        vToken = tokenRepository.save(vToken);
        return vToken;
    }

}