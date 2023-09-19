package com.springmart.springmartbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WishListDto {
    
    private Long id;
    private String springUserId;
}
