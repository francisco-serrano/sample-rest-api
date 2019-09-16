package com.example.samplearchitecture.service;

import com.example.samplearchitecture.dto.CreateCarDTO;
import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Optional<Car> getCar(int id) {
        return this.carRepository.findById(id);
    }

    @Override
    public Car createCar(CreateCarDTO dto) {
        var car = new Car(dto.getBrand(), dto.getModel(), dto.getVersion(), dto.getEngineSize(), dto.getHorsePower());

        return this.carRepository.save(car);
    }
}
