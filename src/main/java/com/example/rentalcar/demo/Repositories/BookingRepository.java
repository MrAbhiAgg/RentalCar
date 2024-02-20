package com.example.rentalcar.demo.Repositories;

import com.example.rentalcar.demo.Modal.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


}
//crud