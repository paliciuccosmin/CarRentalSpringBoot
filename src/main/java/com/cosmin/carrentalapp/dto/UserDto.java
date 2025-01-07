package com.cosmin.carrentalapp.dto;

import com.cosmin.carrentalapp.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String name;
    private UserRole role;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }
}
