package com.example.rentalcar.demo.DTO;

import java.util.List;

public class GetCars {
    public String carType;
    public List<String> cars;

    public GetCars() {
    }

    public GetCars(String carType, List<String> cars) {
        this.carType = carType;
        this.cars = cars;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }
}
