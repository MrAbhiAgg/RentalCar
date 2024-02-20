package com.example.rentalcar.demo.Modal;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @OneToOne
    private Users users;
    @OneToOne
    private Car car;

    private Date fromDate;
    private Date toDate;

    public Booking() {
    }

    public Booking(int id, Users users, Car car, Date fromDate, Date toDate) {
        Id = id;
        this.users = users;
        this.car = car;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
