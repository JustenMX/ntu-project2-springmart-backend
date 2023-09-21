package com.springmart.springmartbackend.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password is required")
    private String password;

    @Column(name = "first_name", nullable = false)
    @NotNull(message = "First name is required")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull(message = "Last name is required")
    private String lastName;

    @Column(name = "address", nullable = false)
    @NotNull(message = "Address is required")
    private String address;

    @Column(name = "postal_code", nullable = false)
    @NotNull(message = "Postalcode is required")
    private String postalCode;

    @Column(name = "unit_no", nullable = false)
    @NotNull(message = "Unit no is required")
    private String unitNo;

    @Column(name = "opt_marketing", nullable = false)
    @NotNull(message = "Opt for marketing is required")
    private boolean optMarketing;

    @Column(name = "join_date", nullable = false)
    @NotNull(message = "Registration date is required")
    @PastOrPresent(message = "Registration date should not be in the future")
    private LocalDate joinDate;

    /**
     * ONE TO ONE
     */

    @OneToOne(mappedBy = "springUser", cascade = CascadeType.ALL)
    private WishList wishList;

    @OneToOne(mappedBy = "springUser", cascade = CascadeType.ALL)
    private Cart cart;

}
