package com.example.samplearchitecture.repository;

import com.example.samplearchitecture.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
