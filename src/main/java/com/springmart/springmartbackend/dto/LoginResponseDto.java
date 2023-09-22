package com.springmart.springmartbackend.dto;

import com.springmart.springmartbackend.entity.SpringUserAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private SpringUserAuth springUserAuth;
    private String jwt;
}
