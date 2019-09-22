package com.example.samplearchitecture.integration;

import com.example.samplearchitecture.entity.Car;
import com.example.samplearchitecture.repository.CarRepository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarTests extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private CarRepository carRepository;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeClass
    public void setup() {
        this.carRepository.deleteAll();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "5-Series", "M5", 4400, 600));
        cars.add(new Car("Audi", "A4", "3.0T", 3000, 330));

        this.carRepository.saveAll(cars);
    }

    @AfterClass
    public void teardown() {
        this.carRepository.deleteAll();
    }

    @Test
    public void testGetAllCars() throws Exception {
        var response = getRequest("/first-service/cars");

        var expectedStatusCode = HttpStatus.OK;
        var actualStatusCode = response.getStatusCode();

        assertEquals(expectedStatusCode, actualStatusCode);

        List<Car> expectedCars = new ArrayList<>();
        expectedCars.add(new Car("BMW", "5-Series", "M5", 4400, 600));
        expectedCars.add(new Car("Audi", "A4", "3.0T", 3000, 330));

        List<Car> actualCars = new ObjectMapper().readValue(response.getBody(), new TypeReference<List<Car>>(){});

        assertEquals(expectedCars.size(), actualCars.size());
    }

    private ResponseEntity<String> getRequest(String uri) {
        return this.restTemplate.getForEntity(createURLWithPort(uri), String.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
