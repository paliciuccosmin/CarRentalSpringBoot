package com.cosmin.carrentalapp.repository;

import com.cosmin.carrentalapp.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarRepository extends JpaRepository<Car, Long> {


}
