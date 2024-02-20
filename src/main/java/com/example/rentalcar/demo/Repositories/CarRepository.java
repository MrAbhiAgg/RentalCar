package com.example.rentalcar.demo.Repositories;

import com.example.rentalcar.demo.Modal.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query("SELECT c FROM Car c WHERE NOT EXISTS (SELECT 1 FROM Booking b WHERE c.id = b.car.id AND :date BETWEEN b.fromDate AND b.toDate)")
    List<Car> findAvailableCars(@Param("date") Date date);
}
