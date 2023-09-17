package com.springmart.springmartbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.springmart.springmartbackend.dto.SpringUserUpdate;
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

    /**
     * GET ALL USERS
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<SpringUser>> getAllUsers() {
        List<SpringUser> allUsers = springUserService.getAllUsers();
        logger.info("Retrieved {} users successfully", allUsers.size());
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
        logger.info("Retrieved user [ID: {}, Name: {}] successfully", springUser.getId(), springUser.getFirstName());
        return new ResponseEntity<>(springUser, HttpStatus.OK);
    }

    /**
     * UPDATE USER
     * 
     * @param id
     * @param springUserUpdate
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<SpringUser> updateUser(@PathVariable Long id,
            @RequestBody SpringUserUpdate springUserUpdate) {
        SpringUser updateUser = springUserService.updateUser(id, springUserUpdate);
        logger.info("Updated user [ID: {}, Name: {} {}]", updateUser.getId(), updateUser.getFirstName());
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
        logger.info("Deleted user with ID: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
