package com.springmart.springmartbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpringUserAuthentication {
    private String email;
    private String password;
}
