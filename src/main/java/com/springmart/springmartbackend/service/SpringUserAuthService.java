package com.springmart.springmartbackend.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.SpringUserAuthRepository;
import com.springmart.springmartbackend.dto.LoginRequestDto;
import com.springmart.springmartbackend.dto.LoginResponseDto;
import com.springmart.springmartbackend.entity.SpringUserAuth;
import com.springmart.springmartbackend.exception.AuthenticationFailureException;
import com.springmart.springmartbackend.exception.SpringUserAuthNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpringUserAuthService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private SpringUserAuthRepository springUserAuthRepository;
    private TokenService tokenService;

    /**
     * LOAD USER BY USERNAME
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the springuser auth service");

        return springUserAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));

    }

    /**
     * AUTHENTICATE SPRING USER LOGIN
     * 
     * @param loginRequestDto
     * @return
     */
    public LoginResponseDto authenticateLogin(LoginRequestDto loginRequestDto) {
        System.out.println("In the springuser auth service (authenticate login)");
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        //
        SpringUserAuth userDetails = springUserAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));

        System.out.println("Entered Password: " + password);
        System.out.println("Stored Password: " + userDetails.getPassword());

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new AuthenticationFailureException("Invalid credentials");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        System.out.println("Authenticated");

        String jwtToken = tokenService.generateJwt(authentication);

        System.out.println("Generated JWT Token: " + jwtToken);

        return new LoginResponseDto((SpringUserAuth) userDetails, jwtToken);
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
