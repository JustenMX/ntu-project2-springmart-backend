package com.springmart.springmartbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/springmart/api/admin")
public class SpringAdminController {

    @GetMapping("/hello")
    public String helloSpringAdminController() {
        return "Springmart Admin Level Access";
    }
}
