package com.springmart.springmartbackend.service;

import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.entity.SpringUser;

public interface SpringUserService {

    /**
     * Create User
     * 
     * @param userDto
     */
    SpringUser registerUser(SpringUserRegistration springUserRegistration);

}
