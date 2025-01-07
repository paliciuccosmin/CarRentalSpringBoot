package com.cosmin.carrentalapp.services.admin;

import com.cosmin.carrentalapp.dto.CarDto;

import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto);
    List<CarDto> getAllCars();
}
