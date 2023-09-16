package com.springmart.springmartbackend.service;

import com.springmart.springmartbackend.dao.UserRepository;
import com.springmart.springmartbackend.dto.UserDto;
import com.springmart.springmartbackend.entity.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        user.setOptMarketing(userDto.isOptMarketing());
        user.setJoinDate(userDto.getJoinDate());
        userRepository.save(user);
    }
}
