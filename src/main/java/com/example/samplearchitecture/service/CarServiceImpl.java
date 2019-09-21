package com.example.samplearchitecture.service;

import com.example.samplearchitecture.dto.CreateUpdateCarDTO;
import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.repository.CarRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Car> getCars() {
        return Lists.newArrayList(this.carRepository.findAll());
    }

    @Override
    public Car createCar(CreateUpdateCarDTO dto) {
        var car = new Car(dto);

        return this.carRepository.save(car);
    }

    @Override
    @Transactional
    public Optional<Car> updateCar(int id, CreateUpdateCarDTO dto) {
        var car = this.carRepository.findById(id);

        if (car.isPresent()) {
            var updatedCar = car.get();

            updatedCar.setBrand(dto.getBrand());
            updatedCar.setEngineSize(dto.getEngineSize());
            updatedCar.setHorsePower(dto.getHorsePower());
            updatedCar.setModel(dto.getModel());
            updatedCar.setVersion(dto.getVersion());

            this.carRepository.save(updatedCar);
        }

        return car;
    }

    @Override
    @Transactional
    public Optional<Car> deleteCar(int id) {
        var car = this.carRepository.findById(id);

        car.ifPresent(value -> this.carRepository.delete(value));

        return car;
    }
}
