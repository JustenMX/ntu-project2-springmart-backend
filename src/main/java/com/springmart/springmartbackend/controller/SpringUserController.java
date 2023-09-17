package com.springmart.springmartbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/")
public class SpringUserController {

    private SpringUserServiceImplementation springUserService;

    @PostMapping("register")
    public ResponseEntity<SpringUser> registerUser(@RequestBody SpringUserRegistration springUserRegistration) {
        return new ResponseEntity<>(springUserService.registerUser(springUserRegistration), HttpStatus.OK);
    }
}
