package com.example.rentalcar.demo.DTO;

import java.sql.Date;

public class BookCarDTO {
    private String email;
    private String carName;

    private Date bookingFromDate;
    private Date bookingToDate;

    public BookCarDTO() {
    }

    public BookCarDTO(String email, String carName, Date bookingFromDate, Date bookingToDate) {
        this.email = email;
        this.carName = carName;
        this.bookingFromDate = bookingFromDate;
        this.bookingToDate = bookingToDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Date getBookingFromDate() {
        return bookingFromDate;
    }

    public void setBookingFromDate(Date bookingFromDate) {
        this.bookingFromDate = bookingFromDate;
    }

    public Date getBookingToDate() {
        return bookingToDate;
    }

    public void setBookingToDate(Date bookingToDate) {
        this.bookingToDate = bookingToDate;
    }
}
