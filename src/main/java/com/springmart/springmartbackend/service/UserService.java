package com.springmart.springmartbackend.service;

import com.springmart.springmartbackend.dto.UserDto;
import com.springmart.springmartbackend.entity.User;

public interface UserService {

    /**
     * Create User
     * 
     * @param userDto
     */
    User registerUser(UserDto userDto);

}
