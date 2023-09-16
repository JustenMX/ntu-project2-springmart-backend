package com.springmart.springmartbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.UserDto;
import com.springmart.springmartbackend.entity.User;
import com.springmart.springmartbackend.service.UserServiceImplementation;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    private UserServiceImplementation userService;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.OK);
    }

}
