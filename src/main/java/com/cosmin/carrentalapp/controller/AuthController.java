package com.cosmin.carrentalapp.controller;

import com.cosmin.carrentalapp.dto.SignupRequest;
import com.cosmin.carrentalapp.dto.UserDto;
import com.cosmin.carrentalapp.services.auth.AuthService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        if(authService.checkIfUsernameExists(signupRequest.getUsername())) {
            return new ResponseEntity<>("Numele de utilizator există deja", HttpStatus.BAD_REQUEST);
        }
        if(authService.validPassword(signupRequest.getPassword()) != null) {
            return new ResponseEntity<>(authService.validPassword(signupRequest.getPassword()), HttpStatus.BAD_REQUEST);
        }
        UserDto createdUserDto = authService.createCustomer(signupRequest);
        if(createdUserDto == null) {
            return new  ResponseEntity<>("Utilizatorul nu a fost creat", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Utilizatorul a fost creat", HttpStatus.CREATED);
    }
}
