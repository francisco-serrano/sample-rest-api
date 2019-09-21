package com.example.samplearchitecture.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUpdateCarDTO {
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("version")
    private String version;

    @JsonProperty("engine_size")
    private int engineSize;

    @JsonProperty("horse_power")
    private int horsePower;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public int getHorsePower() {
        return horsePower;
    }
}
