package com.springmart.springmartbackend.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringUserDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String unitNo;
    private boolean optMarketing;
    private LocalDate joinDate;
}
