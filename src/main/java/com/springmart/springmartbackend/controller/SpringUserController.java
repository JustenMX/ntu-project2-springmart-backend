package com.springmart.springmartbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.service.SpringUserServiceImplementation;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/springmart/api/user")
public class SpringUserController {

    private Logger logger = LoggerFactory.getLogger(SpringUserController.class);
    private SpringUserServiceImplementation springUserService;

    /**
     * CREATE USER
     * 
     * @param springUserRegistration
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<SpringUser> registerUser(@RequestBody SpringUserRegistration springUserRegistration) {
        logger.info("Added new customer [ID: {}, Name: {}]", springUserRegistration.getId(),
                springUserRegistration.getFirstName());
        return new ResponseEntity<>(springUserService.registerUser(springUserRegistration), HttpStatus.OK);
    }

    // @GetMapping
    // public ResponseEntity<List<SpringUser>> getAllUsers() {
    // List<SpringUser> allUsers = springUserService.getAllUsers();
    // }

}
