package com.example.demo.service;

import com.example.demo.models.Role;
import com.example.demo.models.Subject;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "https://localhost:3000")
public class RoleService {
    
    private RoleRepository roleRepository;



    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public void addNewRole(Role role) {
        roleRepository.save(role);
    }


    public void deleteRole(Long roleId) {
        boolean exists = roleRepository.existsById(roleId);
        if(!exists){
            throw new IllegalStateException("subject with id " + roleId +
                    " does not exist");
        }
        roleRepository.deleteById(roleId);
    }


}
