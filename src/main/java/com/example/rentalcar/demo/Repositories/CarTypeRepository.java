package com.example.rentalcar.demo.Repositories;

import com.example.rentalcar.demo.Modal.Car;
import com.example.rentalcar.demo.Modal.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType,Integer> {

    CarType findByTypeName(String name);

    @Query("Select p from CarType p LEFT JOIN FETCH p.carList")
    List<CarType> findWithOutNPlusOne();

}
