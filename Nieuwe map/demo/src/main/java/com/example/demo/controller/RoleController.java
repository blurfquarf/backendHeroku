package com.example.demo.controller;
import com.example.demo.models.Role;
import com.example.demo.models.Subject;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Role> getRole(){
        return roleService.getRoles();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void registerNewRole(@RequestBody Role role){
        roleService.addNewRole(role);
    }

    @DeleteMapping("{subjectId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteSubject(@PathVariable("roleId") Long roleId){
        roleService.deleteRole(roleId);
    }

}
