package com.cosmin.carrentalapp.model;

import com.cosmin.carrentalapp.dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "cars")

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String transmission;
    private String fuelType;
    private int year;
    private int price;
    private String imageUrl;

    public CarDto getCarDto() {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setBrand(brand);
        carDto.setModel(model);
        carDto.setTransmission(transmission);
        carDto.setFuelType(fuelType);
        carDto.setYear(year);
        carDto.setPrice(price);
        carDto.setImageUrl(imageUrl);
        return carDto;
    }
}
