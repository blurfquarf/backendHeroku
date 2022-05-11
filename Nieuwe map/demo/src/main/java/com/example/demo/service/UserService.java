package com.example.demo.service;

import com.example.demo.checks.EmailExists;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final SubjectRepository subjectRepository;

    @Autowired
    public UserService(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    public List<User> getPersons(){
        return userRepository.findAll();
    }


    private boolean emailExist(final String email) {
        return userRepository.findByEmail(email) != null;
    }


    public void addNewPerson(User user) throws EmailExists {
        if (emailExist(user.getEmail())) {
            throw new EmailExists(
                    "There is an account with that email adress:" + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
/*
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

*/

    /*
    public void registerNewAccount(User user) throws EmailExists {
        if (emailExist(user.getEmail())) {
            throw new EmailExists(
                    "There is an account with that email adress:" + user.getEmail());
        }

        addNewPerson(user);
        user.setRoles(Arrays.asList(roleRepository.findByName("BEDRIJFSVERANTWOORDELIJKE")));
    }
*/
/*


    //@Override
    public VerificationToken getVerificationToken(final String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

*/
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


    public List<User> getPros() {
        List<User> temp = userRepository.findAll();
        Role role = roleRepository.findByName("ROLE_PROMOTOR");
        List<User> pros = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            if (temp.get(i).getRoles().contains(role)){
                pros.add(temp.get(i));
            }
        }
        return pros;
    }

    public void setK1(String keuze1, String studentMail){
        User u = userRepository.findByEmail(studentMail);
        Subject s = subjectRepository.findByName(keuze1);
        u.setKeuze1(s);
    }

    public void setK2(String keuze2, String studentMail){
        User u = userRepository.findByEmail(studentMail);
        Subject s = subjectRepository.findByName(keuze2);
        u.setKeuze2(s);
    }

    public void setK3(String keuze3, String studentMail){
        User u = userRepository.findByEmail(studentMail);
        Subject s = subjectRepository.findByName(keuze3);
        u.setKeuze3(s);
    }

    //student per subject met keuznr
    public Map<Integer, User> getSperSub(String subjectName){
        Subject s = subjectRepository.findByName(subjectName);
        List<User> users = userRepository.findAll();
        Map<Integer, User> userMetKeuze = new HashMap<>();

        for(int i = 0; i < users.size(); i ++){
            if(s == users.get(i).getKeuze1()) {
                userMetKeuze.put(1, users.get(i));
            }
            else if(s == users.get(i).getKeuze2()) {
                userMetKeuze.put(2, users.get(i));
            }
            else if(s == users.get(i).getKeuze3()) {
                userMetKeuze.put(3, users.get(i));
            }
        }
        return userMetKeuze;
    }

    public Campus getCampus(String mail){
        User u = userRepository.findByEmail(mail);
        return u.getCampus();
    }

    public Opleiding getOpleiding(String mail){
        User u = userRepository.findByEmail(mail);
        return u.getOpleiding();
    }


    //beschikbare onderwerpen toepasbaar op coordinator
    public List<Subject> getSubsPerCoord(String mail){
        User u = userRepository.findByEmail(mail);
        List<Subject> targetSubjects = new ArrayList<>();
        List<Subject> all = subjectRepository.findAll();
        for(int i = 0; i < all.size(); i++){
            if (all.get(i).getOpleidingen().contains(u.getOpleiding()) && all.get(i).getCampussen().contains(u.getCampus())
            && !all.get(i).getNietMeerBeschikbaar()){
                targetSubjects.add(all.get(i));
            }
        }
        return targetSubjects;
    }

    public void setSubject(String subjectName, String studentMail){
        Subject s = subjectRepository.findByName(subjectName);
        User u = userRepository.findByEmail(studentMail);
        u.setSubject(s);
        u.setHeeftDefinitiefOnderwerp();
        s.setNietMeerBeschikbaar();
    }

    public void setBoost(String subjectName, String studentMail) {
        Subject s = subjectRepository.findByName(subjectName);
        User u = userRepository.findByEmail(studentMail);
        u.addBoost(s);
    }

    public void setK123(String keuze1, String keuze2, String keuze3, String studentMail) {
        Subject s1 = subjectRepository.findByName(keuze1);
        Subject s2 = subjectRepository.findByName(keuze2);
        Subject s3 = subjectRepository.findByName(keuze3);

        User u = userRepository.findByEmail(studentMail);
        u.setKeuze1(s1);
        u.setKeuze2(s2);
        u.setKeuze3(s3);
    }

    public Integer getStudCount(@RequestParam String subjectName){
        Subject s = subjectRepository.findByName(subjectName);
        List<User> users = userRepository.findAll();
        Integer count = 0;

        for(int i = 0; i < users.size(); i ++){
            if(s == users.get(i).getKeuze1() ||
                    s == users.get(i).getKeuze2() ||
                    s == users.get(i).getKeuze3() ) {
                count++;
            }
        }
        return count;
    }
}