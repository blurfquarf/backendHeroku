package com.example.demo.controller;
import com.example.demo.models.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /*
    @GetMapping("/roleHierarchy")
    public ModelAndView roleHierarcy() {
        ModelAndView model = new ModelAndView();
        model.addObject("adminMessage","Admin content available");
        model.addObject("staffMessage","Staff content available");
        model.addObject("userMessage","User content available");
        model.setViewName("roleHierarchy");
        return model;
    }
*/

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Role> getRole(){
        return roleService.getRoles();
    }

}
