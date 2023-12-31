package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.SpringUser;

public interface SpringUserService {

    /**
     * 
     * @param springUserRegistration
     * @return
     */
    SpringUser registerUser(SpringUserRegistration springUserRegistration);

    /**
     * GET ALL USERS
     * 
     * @return
     */
    List<SpringUser> getAllUsers();

    /**
     * GET ONE USER
     * 
     * @param id
     * @return
     */
    SpringUser getUser(Long id);

    /**
     * UPDATE USER
     * 
     * @param id
     * @param springUserUpdate
     * @return
     */
    SpringUser updateUser(Long id, SpringUserDto springUserDto);

    /**
     * DELETE USER
     * 
     * @param id
     */
    void deleteUser(Long id);

}
