package com.example.samplearchitecture.unit;

import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.repository.CarRepository;
import com.example.samplearchitecture.service.CarService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void sampleTest() {
        Optional<Car> optCar = Optional.of(new Car("BMW", "1 Series", "M135i", 2000, 306));

        when(carRepository.findById(1)).thenReturn(optCar);

        var car = this.carService.getCar(1);

        assertTrue(car.isPresent());

        assertEquals("BMW", car.get().getBrand());
    }
}
