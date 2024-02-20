package com.example.rentalcar.demo.Services;

import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.DTO.Type;
import com.example.rentalcar.demo.Modal.Car;
import com.example.rentalcar.demo.Modal.CarType;
import com.example.rentalcar.demo.Repositories.BookingRepository;
import com.example.rentalcar.demo.Repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarTypeService {

    @Autowired
    private CarTypeRepository repository;

    public CarTypeService() {
    }

    public Response AddCarType(Type t)
    {
        Response response = new Response();
        try{
            if(t == null || t.getTypeDescription().equals("") || t.getTypeName().equals("")){
                response.setMessage("data can't be empty");
                return response;
            }

            Optional<CarType> optionalCarType = Optional.ofNullable(repository.findByTypeName(t.getTypeName()));
            if(optionalCarType.isEmpty()){
                CarType carType= new CarType(0,t.getTypeName(),t.getTypeDescription());
                repository.save(carType);
                response.setSuccess(true);
                return response;
            }
            response.setMessage("type already created");

        }catch (Exception e){
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        response.setSuccess(false);
        return response;
    }

    public List<Type> GetType(){
        List<CarType> types = repository.findAll();
        List<Type> dtos = types.stream()
                .map(t -> new Type(t.getTypeName() ,t.getDescription()))
                .collect(Collectors.toList());
        return dtos;
    }
}
