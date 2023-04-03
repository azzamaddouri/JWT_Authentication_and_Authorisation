package com.spring.jwt.auth;

import com.spring.jwt.config.JwtService;
import com.spring.jwt.user.AppRole;
import com.spring.jwt.user.AppUser;
import com.spring.jwt.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AuthenticationService {
    private UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user= AppUser.builder()
                .firstname(request.getFirstName()).lastname(request.getFirstName()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(AppRole.USER)
                .build();
         repository.save(user);
         var jwtToken= jwtService.generateToken(user) ;

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getPassword(),request.password));

var user= repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken= jwtService.generateToken(user) ;
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
