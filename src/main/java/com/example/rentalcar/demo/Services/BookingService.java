package com.example.rentalcar.demo.Services;

import com.example.rentalcar.demo.DTO.BookCarDTO;
import com.example.rentalcar.demo.DTO.GetCars;
import com.example.rentalcar.demo.DTO.Response;
import com.example.rentalcar.demo.Modal.Booking;
import com.example.rentalcar.demo.Modal.Car;
import com.example.rentalcar.demo.Modal.Users;
import com.example.rentalcar.demo.Repositories.BookingRepository;
import com.example.rentalcar.demo.Repositories.CarRepository;
import com.example.rentalcar.demo.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    CarRepository repository;
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UsersRepository userrepository;
    public List<GetCars> AvailableCars(Date date) {

        List<Car> car = repository.findAvailableCars(date);
        // return

        return car.stream().
                collect(Collectors.groupingBy(x -> x.getType().getTypeName(),
                        Collectors.mapping(Car::getCarName, Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new GetCars(entry.getKey(), entry.getValue()))
                .toList();

    }

    public Response BookCar(BookCarDTO bookCarDTO){
        Response response = new Response();
        response.setSuccess(false);
        try{
            Optional<Users> optionalusers = Optional.ofNullable(userrepository.findByEmail(bookCarDTO.getEmail()));
            if(optionalusers.isEmpty()){
                response.setMessage("user not exists");
            }else{
                List<Car> cars = repository.findAvailableCars(bookCarDTO.getBookingFromDate());
                if(!cars.isEmpty()){
                    Car carData = cars.stream().filter(x-> x.getCarName().equals(bookCarDTO.getCarName())).findFirst().orElse(null);
                    if(carData != null){
                        Booking booking = new Booking();
                        booking.setCar(carData);
                        booking.setUsers(optionalusers.get());
                        booking.setFromDate(bookCarDTO.getBookingFromDate());
                        booking.setToDate(bookCarDTO.getBookingToDate());
                        bookingRepository.save(booking);
                        response.setMessage("booking succesfull");
                        response.setSuccess(true);
                    }else{
                        response.setMessage("car not available or not exists");
                    }
                }
            }
        }catch (Exception e){
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
