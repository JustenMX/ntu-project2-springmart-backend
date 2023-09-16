package com.springmart.springmartbackend.service;

import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.SpringUserRepository;
import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.SpringUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpringUserServiceImplementation implements SpringUserService {

    private SpringUserRepository springUserRepository;

    public SpringUser registerUser(SpringUserDto springUserDto) {
        SpringUser springUser = new SpringUser();
        springUser.setEmail(springUserDto.getEmail());
        springUser.setPassword(springUserDto.getPassword());
        springUser.setFirstName(springUserDto.getFirstName());
        springUser.setLastName(springUserDto.getLastName());
        springUser.setAddress(springUserDto.getAddress());
        springUser.setOptMarketing(springUserDto.isOptMarketing());
        springUser.setJoinDate(springUserDto.getJoinDate());
        return springUserRepository.save(springUser);
    }
}
