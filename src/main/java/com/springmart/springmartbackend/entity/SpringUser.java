package com.springmart.springmartbackend.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spring_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SpringUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password is required")
    String password;

    @Column(name = "first_name", nullable = false)
    @NotNull(message = "First name is required")
    String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull(message = "Last name is required")
    String lastName;

    @Column(name = "address", nullable = false)
    @NotNull(message = "Address is required")
    String address;

    @Column(name = "postal_code", nullable = false)
    @NotNull(message = "Postalcode is required")
    String postalCode;

    @Column(name = "unit_no", nullable = false)
    @NotNull(message = "Unit no is required")
    String unitNo;

    @Column(name = "opt_marketing", nullable = false)
    @NotNull(message = "Opt for marketing is required")
    boolean optMarketing;

    @Column(name = "join_date", nullable = false)
    @NotNull(message = "Registration date is required")
    @PastOrPresent(message = "Registration date should not be in the future")
    LocalDate joinDate;
}
