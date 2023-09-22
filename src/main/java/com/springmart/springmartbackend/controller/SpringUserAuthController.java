package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.LoginRequestDto;
import com.springmart.springmartbackend.dto.LoginResponseDto;
import com.springmart.springmartbackend.entity.SpringUserAuth;
import com.springmart.springmartbackend.service.SpringUserAuthService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/springmart/api/authentication")
public class SpringUserAuthController {

    private SpringUserAuthService springUserAuthService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateLogin(@RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(springUserAuthService.authenticateLogin(loginRequestDto), HttpStatus.OK);
    }

    /**
     * GET ALL SPRING USER AUTH
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SpringUserAuth>> getAllSpringUserAuth() {
        return new ResponseEntity<>(springUserAuthService.getAllSpringUserAuth(), HttpStatus.OK);
    }

    /**
     * GET SPRING USER AUTH
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<SpringUserAuth> getSpringUserAuth(@PathVariable Long id) {
        return new ResponseEntity<>(springUserAuthService.getSpringUserAuth(id), HttpStatus.OK);
    }

}
