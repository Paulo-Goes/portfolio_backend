package com.paulo.portfolio.controller;

import com.paulo.portfolio.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    AuthController(JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        try {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            if(passwordEncoder.matches(password, user.getPassword())){
                String token = jwtUtil.generateToken(username);
                return ResponseEntity.ok(Map.of("token", token));
            }
        } catch (Exception e){}

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
    }
    
}
