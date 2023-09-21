package com.springmart.springmartbackend.dto;

import java.util.Set;

import com.springmart.springmartbackend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpringUserAuthDto {
    private Long userId;
    private String username;
    private String password;
    private Set<Role> authorities;
}
