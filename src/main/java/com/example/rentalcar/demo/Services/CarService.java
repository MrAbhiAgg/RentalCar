package com.example.rentalcar.demo.Services;

import com.example.rentalcar.demo.DTO.CarDTO;
import com.example.rentalcar.demo.DTO.GetCars;
import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.Modal.Car;
import com.example.rentalcar.demo.Modal.CarType;
import com.example.rentalcar.demo.Repositories.CarRepository;
import com.example.rentalcar.demo.Repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;
    @Autowired
    private CarTypeRepository carTypeRepository;

    public Response AddCars(CarDTO dto)
    {
        Response response = new Response();
        response.setSuccess(false);
        try{
            Optional<CarType> optionalCarType = Optional.ofNullable(carTypeRepository.findByTypeName(dto.getType()));
            if(optionalCarType.isEmpty()){
                response.setMessage("type not exists");
                return  response;
            }
            Car car = new Car(dto.getCarName(),optionalCarType.get());
            repository.save(car);
            response.setSuccess(true);
            response.setMessage("car added successfully");
        }catch (Exception e){
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public List<GetCars> getCars(){
        List<GetCars> cars = new ArrayList<>();
        try{
            List<CarType> types = carTypeRepository.findWithOutNPlusOne();


            for(CarType ct:types){
                GetCars getCars = new GetCars();
                getCars.carType = ct.getTypeName();
                getCars.cars = new ArrayList<>();
                for (Car car : ct.getCarList()){
                    getCars.cars.add(car.getCarName());
                }
                cars.add(getCars);
            }
        }catch (Exception e){
            String msg = e.getMessage();
        }
        return cars;




//
//        return types.stream()
//                .map(carType -> {
//                    GetCars getCars = new GetCars();
//                    getCars.carType = carType.getTypeName();
//                    getCars.cars = carType.getCarList().stream()
//                            .map(Car::getCarName)
//                            .collect(Collectors.toList());
//                    return getCars;
//                })
//                .toList();
    }
}
