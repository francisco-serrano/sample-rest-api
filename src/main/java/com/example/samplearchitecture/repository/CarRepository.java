package com.example.samplearchitecture.repository;

import com.example.samplearchitecture.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
