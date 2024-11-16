package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.CarListingResponseDTO;
import dev.bcgcompany.mobiliza.entities.Car;
import dev.bcgcompany.mobiliza.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarListingResponseDTO> listAllCars() {
        List<Car> cars = carRepository.findByRentedFalse();
        return cars.stream().map(CarListingResponseDTO::new).toList();
    }
}