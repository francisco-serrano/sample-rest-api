package com.example.samplearchitecture.entity;

import com.example.samplearchitecture.dto.CreateUpdateCarDTO;

import javax.persistence.*;

@Entity
public class Car {

    public Car() {
    }

    public Car(String brand, String model, String version, int engineSize, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.engineSize = engineSize;
        this.horsePower = horsePower;
    }

    public Car(CreateUpdateCarDTO dto) {
        this(dto.getBrand(), dto.getModel(), dto.getVersion(), dto.getEngineSize(), dto.getHorsePower());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private int engineSize;

    @Column(nullable = false)
    private int horsePower;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
