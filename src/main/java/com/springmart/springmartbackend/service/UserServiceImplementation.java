package com.springmart.springmartbackend.service;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.UserRepository;
import com.springmart.springmartbackend.dto.UserDto;
import com.springmart.springmartbackend.entity.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        user.setOptMarketing(userDto.isOptMarketing());
        user.setJoinDate(userDto.getJoinDate());
        return userRepository.save(user);
    }
}
