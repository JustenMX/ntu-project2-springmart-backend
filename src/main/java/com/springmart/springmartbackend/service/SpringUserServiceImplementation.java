package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.SpringUserRepository;
import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.dto.SpringUserUpdate;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.exception.SpringUserNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpringUserServiceImplementation implements SpringUserService {

    private SpringUserRepository springUserRepository;

    /**
     * CREATE USER
     */
    @Override
    public SpringUser registerUser(SpringUserRegistration springUserRegistration) {
        SpringUser springUser = new SpringUser();
        springUser.setEmail(springUserRegistration.getEmail());
        springUser.setPassword(springUserRegistration.getPassword());
        springUser.setFirstName(springUserRegistration.getFirstName());
        springUser.setLastName(springUserRegistration.getLastName());
        springUser.setAddress(springUserRegistration.getAddress());
        springUser.setPostalCode(springUserRegistration.getPostalCode());
        springUser.setUnitNo(springUserRegistration.getUnitNo());
        springUser.setOptMarketing(springUserRegistration.isOptMarketing());
        springUser.setJoinDate(springUserRegistration.getJoinDate());
        return springUserRepository.save(springUser);
    }

    /**
     * GET ALL USERS
     */
    @Override
    public List<SpringUser> getAllUsers() {
        List<SpringUser> allUsers = springUserRepository.findAll();
        return allUsers;
    }

    /**
     * GET ONE USER
     */
    @Override
    public SpringUser getUser(Long id) {
        SpringUser springUser = springUserRepository.findById(id)
                .orElseThrow(() -> new SpringUserNotFoundException(id));
        return springUser;
    }

    /**
     * UPDATE USER
     */
    @Override
    public SpringUser updateUser(Long id, SpringUserUpdate springUserUpdate) {
        SpringUser updateUser = springUserRepository.findById(id)
                .orElseThrow(() -> new SpringUserNotFoundException(id));
        updateUser.setEmail(springUserUpdate.getEmail());
        updateUser.setPassword(springUserUpdate.getPassword());
        updateUser.setFirstName(springUserUpdate.getFirstName());
        updateUser.setLastName(springUserUpdate.getLastName());
        updateUser.setAddress(springUserUpdate.getAddress());
        updateUser.setPostalCode(springUserUpdate.getPostalCode());
        updateUser.setUnitNo(springUserUpdate.getUnitNo());
        updateUser.setOptMarketing(springUserUpdate.isOptMarketing());
        updateUser.setJoinDate(springUserUpdate.getJoinDate());
        return updateUser;
    }

    /**
     * DELETE USER
     */
    @Override
    public void deleteUser(Long id) {
        springUserRepository.deleteById(id);
    }
}
