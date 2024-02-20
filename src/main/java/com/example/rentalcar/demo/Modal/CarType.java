package com.example.rentalcar.demo.Modal;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="type_name")
    private String typeName;
    private String description;
    @OneToMany(mappedBy = "type")
    private List<Car> carList;

    public CarType() {
    }

    public CarType(int id, String typeName, String description) {
        Id = id;
        this.typeName = typeName;
        this.description = description;
    }

    public CarType(int id, String typeName, String description, List<Car> carList) {
        Id = id;
        this.typeName = typeName;
        this.description = description;
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
