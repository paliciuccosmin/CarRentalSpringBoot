package com.cosmin.carrentalapp.controller;

import com.cosmin.carrentalapp.dto.LoginRequest;
import com.cosmin.carrentalapp.services.auth.AuthService;

import com.cosmin.carrentalapp.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest) {
        UserDto userDto = authService.loginCustomer(loginRequest.getUsername(), loginRequest.getPassword());
        if (userDto == null) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

        // Return the URL to redirect based on the role
        String redirectUrl = "home";  // Default role (non-admin)
        if (userDto.getRole().toString().equals("ADMIN")) {
            redirectUrl = "admin";  // If the user is an admin
        }

        return new ResponseEntity<>(redirectUrl, HttpStatus.OK);
    }
}
