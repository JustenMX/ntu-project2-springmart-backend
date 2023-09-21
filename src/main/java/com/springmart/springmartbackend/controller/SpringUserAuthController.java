package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.entity.SpringUserAuth;
import com.springmart.springmartbackend.service.SpringUserAuthService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/springmart/api/userauth")
public class SpringUserAuthController {

    private SpringUserAuthService springUserAuthService;

    /**
     * GET ALL SPRING USER AUTH
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SpringUserAuth>> getAllSpringUserAuth() {
        return new ResponseEntity<>(springUserAuthService.getAllSpringUserAuth(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpringUserAuth> getSpringUserAuth(@PathVariable Long id) {
        return new ResponseEntity<>(springUserAuthService.getSpringUserAuth(id), HttpStatus.OK);
    }

}
