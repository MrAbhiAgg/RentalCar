package com.example.rentalcar.demo.Controller;

import com.example.rentalcar.demo.DTO.CarDTO;
import com.example.rentalcar.demo.DTO.GetCars;
import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService service;

    @PostMapping("/addcar")
    public String AddCars(@RequestBody CarDTO dto){
        Response response = new Response();
        response = service.AddCars(dto);
        return response.getMessage();
    }

    @GetMapping("/getcars")
    public List<GetCars> cars(){
        return service.getCars();
    }
}
