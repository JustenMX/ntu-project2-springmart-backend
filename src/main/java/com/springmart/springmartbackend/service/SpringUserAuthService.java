package com.springmart.springmartbackend.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springmart.springmartbackend.entity.Role;
import com.springmart.springmartbackend.entity.SpringUserAuthDetails;

public class SpringUserAuthService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the springuser auth service");

        if (!username.equals("Justen"))
            throw new UsernameNotFoundException("Not Justen");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(null, "USER"));

        return new SpringUserAuthDetails(1L, "Justen", encoder.encode("password"), roles);

    }
}
