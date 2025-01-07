package com.cosmin.carrentalapp.controller;

import com.cosmin.carrentalapp.dto.CarDto;
import com.cosmin.carrentalapp.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/car")
    public ResponseEntity<?> postCar(@RequestBody CarDto carDto) {

        boolean success = adminService.postCar(carDto);
        if (success) {
            return new ResponseEntity<>("Car added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error adding car", HttpStatus.BAD_REQUEST);
        }
    }

}
