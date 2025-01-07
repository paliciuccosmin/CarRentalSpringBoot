package com.cosmin.carrentalapp.dto;

import com.cosmin.carrentalapp.enums.UserRole;
import lombok.Data;


public class SignupRequest {

    private String username;
    private String password;
    private String name;

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
