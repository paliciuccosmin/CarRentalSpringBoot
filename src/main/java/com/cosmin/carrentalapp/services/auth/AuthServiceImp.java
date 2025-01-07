package com.cosmin.carrentalapp.services.auth;

import com.cosmin.carrentalapp.dto.SignupRequest;
import com.cosmin.carrentalapp.dto.UserDto;
import com.cosmin.carrentalapp.enums.UserRole;
import com.cosmin.carrentalapp.model.User;
import com.cosmin.carrentalapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;

    @Override
    public UserDto createCustomer(@org.jetbrains.annotations.NotNull SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setName(signupRequest.getName());
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return userRepository.findFirstByUsername(username).isPresent();
    }

    @Override
    public String validPassword(String password) {
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        int digitCount = 0;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                hasSpecialChar = true;
            }
        }

        if (!hasLowercase) {
            return "Parola trebuie să conțină cel puțin o literă mică.";
        }
        if (!hasUppercase) {
            return "Parola trebuie să conțină cel puțin o literă mare.";
        }
        if (digitCount < 4) {
            return "Parola trebuie să conțină cel puțin 4 cifre.";
        }
        if (!hasSpecialChar) {
            return "Parola trebuie să conțină cel puțin un caracter special.";
        }

        return null; // Password is valid if all checks are passed
    }

    @Override
    public UserDto loginCustomer(String username, String password) {
        User user = userRepository.findFirstByUsername(username).orElse(null);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}
