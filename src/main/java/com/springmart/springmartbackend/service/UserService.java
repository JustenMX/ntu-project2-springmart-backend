package com.springmart.springmartbackend.service;

import com.springmart.springmartbackend.dto.UserDto;

public interface UserService {

    /**
     * Create User
     * 
     * @param userDto
     */
    void registerUser(UserDto userDto);

}
