package com.example.rentalcar.demo.Controller;

import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.DTO.Type;
import com.example.rentalcar.demo.Services.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartype")
public class CarTypeController {

    @Autowired
    private CarTypeService service;

    @Autowired
    Response response;

    @PostMapping("/add")
    private String AddType(@RequestBody Type t){
        response = service.AddCarType(t);
        if(response.isSuccess()){
            return "Car Type added successfully";
        }else{
            return response.getMessage();
        }
    }

    @GetMapping("/gettypes")
    private List<Type> GetTypes(){
        return service.GetType();
    }

}
