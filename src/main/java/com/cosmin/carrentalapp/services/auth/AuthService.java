package com.cosmin.carrentalapp.services.auth;

import com.cosmin.carrentalapp.dto.SignupRequest;
import com.cosmin.carrentalapp.dto.UserDto;


public interface AuthService {
    public UserDto createCustomer(SignupRequest signupRequest);
    public boolean checkIfUsernameExists(String username);
    public String validPassword(String password);
    public UserDto loginCustomer(String username, String password);
}

