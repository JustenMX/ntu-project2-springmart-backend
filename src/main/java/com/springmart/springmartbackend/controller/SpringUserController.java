package com.springmart.springmartbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.service.SpringUserServiceImplementation;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/springmart/api/user")
public class SpringUserController {

    private SpringUserServiceImplementation springUserService;

    @GetMapping
    public String helloSpringUserController() {
        return "Springmart User Level Access";
    }

    /**
     * CREATE USER
     * 
     * @param springUserRegistration
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<SpringUser> registerUser(@RequestBody SpringUserRegistration springUserRegistration) {
        return new ResponseEntity<>(springUserService.registerUser(springUserRegistration), HttpStatus.OK);
    }

    /**
     * GET ALL USERS
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SpringUser>> getAllUsers() {
        List<SpringUser> allUsers = springUserService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);

    }

    /**
     * GET ONE USER
     * 
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<SpringUser> getUser(@PathVariable Long id) {
        SpringUser springUser = springUserService.getUser(id);
        return new ResponseEntity<>(springUser, HttpStatus.OK);
    }

    /**
     * UPDATE USER
     * 
     * @param id
     * @param springUserDto
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<SpringUser> updateUser(@PathVariable Long id,
            @RequestBody SpringUserDto springUserDto) {
        SpringUser updateUser = springUserService.updateUser(id, springUserDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    /**
     * DELETE USER
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        springUserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
