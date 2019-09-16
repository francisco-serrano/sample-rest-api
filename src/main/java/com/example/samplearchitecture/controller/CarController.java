package com.example.samplearchitecture.controller;

import com.example.samplearchitecture.dto.CreateCarDTO;
import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/first-service")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id) {
        return this.carService.getCar(id);
    }

    @PostMapping("/cars")
    public Optional<Car> createCar(@RequestBody CreateCarDTO dto) {
        return Optional.of(this.carService.createCar(dto));
    }
}
