package com.springmart.springmartbackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.SpringUserAuthRepository;
import com.springmart.springmartbackend.entity.Role;
import com.springmart.springmartbackend.entity.SpringUserAuth;
import com.springmart.springmartbackend.exception.SpringUserAuthNotFoundException;

@Service
public class SpringUserAuthService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SpringUserAuthRepository springUserAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the springuser auth service");

        if (!username.equals("Justen"))
            throw new UsernameNotFoundException("Not Justen");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(null, "USER"));

        return new SpringUserAuth(1L, "Justen", encoder.encode("password"), roles);

    }

    /**
     * GET ALL SPRING USER AUTH
     * 
     * @return
     */
    public List<SpringUserAuth> getAllSpringUserAuth() {
        return springUserAuthRepository.findAll();
    }

    public SpringUserAuth getSpringUserAuth(Long id) {
        SpringUserAuth springUserAuth = springUserAuthRepository.findById(id)
                .orElseThrow(() -> new SpringUserAuthNotFoundException(id));
        return springUserAuth;
    }

}
