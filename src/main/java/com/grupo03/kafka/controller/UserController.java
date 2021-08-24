package com.grupo03.kafka.controller;

import com.grupo03.kafka.model.MyUser;
import com.grupo03.kafka.service.UserService;
import com.grupo03.kafka.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody MyUser myUserRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUserRequest.getUsername(), myUserRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Username or password wrong.", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(myUserRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

}