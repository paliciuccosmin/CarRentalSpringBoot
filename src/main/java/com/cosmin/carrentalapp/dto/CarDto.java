package com.cosmin.carrentalapp.dto;


import lombok.Data;

import java.util.Date;

@Data

public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private String transmission;
    private String fuelType;
    private int year;
    private int price;
    private String imageUrl;

}
