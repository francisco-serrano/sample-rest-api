package com.example.samplearchitecture.service;

import com.example.samplearchitecture.dto.CreateCarDTO;
import com.example.samplearchitecture.entity.Car;

import java.util.Optional;

public interface CarService {
    Optional<Car> getCar(int id);
    Car createCar(CreateCarDTO createCarDTO);
}
