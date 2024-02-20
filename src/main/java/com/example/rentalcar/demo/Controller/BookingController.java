package com.example.rentalcar.demo.Controller;

import com.example.rentalcar.demo.DTO.BookCarDTO;
import com.example.rentalcar.demo.DTO.GetCars;
import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService service;
    @GetMapping("/availablecars")
    public List<GetCars> GetAvailableCars(@RequestParam Date date){
        return service.AvailableCars(date);
    }

    @PostMapping("/bookcar")
    public String BookCar(@RequestBody BookCarDTO dto){
        Response response = service.BookCar(dto);
        return response.getMessage();
    }
}
