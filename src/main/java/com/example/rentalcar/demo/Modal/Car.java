package com.example.rentalcar.demo.Modal;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String CarName;
    @ManyToOne
    private CarType type;

    public Car() {
    }

    public Car(String carName, CarType type) {
        CarName = carName;
        this.type = type;
    }

    public Car(int id, String carName, CarType type) {
        Id = id;
        CarName = carName;
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
