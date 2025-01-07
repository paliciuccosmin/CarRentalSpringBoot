package com.cosmin.carrentalapp.services.admin;

import com.cosmin.carrentalapp.dto.CarDto;
import com.cosmin.carrentalapp.model.Car;
import com.cosmin.carrentalapp.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService{

    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) {
        try {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setTransmission(carDto.getTransmission());
        car.setFuelType(carDto.getFuelType());
        car.setYear(carDto.getYear());
        car.setPrice(carDto.getPrice());
        car.setImageUrl(carDto.getImageUrl());
        carRepository.save(car);
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(car.getCarDto());
        }
        return carDtos;
    }
}
