package com.example.samplearchitecture.controller;

import com.example.samplearchitecture.dto.CreateUpdateCarDTO;
import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/cars")
    public List<Car> getCars() {
        return this.carService.getCars();
    }

    @PostMapping("/cars")
    public Optional<Car> createCar(@RequestBody CreateUpdateCarDTO dto) {
        return Optional.of(this.carService.createCar(dto));
    }

    @PutMapping("/cars/{id}")
    public Optional<Car> updateCar(@PathVariable("id") int id, @RequestBody CreateUpdateCarDTO dto) {
        return this.carService.updateCar(id, dto);
    }

    @DeleteMapping("/cars/{id}")
    public Optional<Car> deleteCar(@PathVariable("id") int id) {
        return this.carService.deleteCar(id);
    }
}
