package com.example.rentalcar.demo.DTO;

public class CarDTO {
    private String CarName;
    private String Type;

    public CarDTO() {
    }

    public CarDTO(String carName, String type) {
        CarName = carName;
        Type = type;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
