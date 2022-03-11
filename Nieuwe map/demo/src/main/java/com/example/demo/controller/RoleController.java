package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

    @GetMapping("/roleHierarchy")
    public ModelAndView roleHierarcy() {
        ModelAndView model = new ModelAndView();
        model.addObject("adminMessage","Admin content available");
        model.addObject("staffMessage","Staff content available");
        model.addObject("userMessage","User content available");
        model.setViewName("roleHierarchy");
        return model;
    }

}
