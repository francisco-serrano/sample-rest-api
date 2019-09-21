package com.example.samplearchitecture.service;

import com.example.samplearchitecture.dto.CreateUpdateCarDTO;
import com.example.samplearchitecture.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Optional<Car> getCar(int id);
    List<Car> getCars();
    Car createCar(CreateUpdateCarDTO createUpdateCarDTO);
    Optional<Car> updateCar(int id, CreateUpdateCarDTO dto);
    Optional<Car> deleteCar(int id);
}
