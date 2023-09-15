package com.springmart.springmartbackend.dto;

import lombok.Data;

@Data
public class PaymentInfo {
    private String currency;
    private int amount;
    private String receiptEmail;
}
