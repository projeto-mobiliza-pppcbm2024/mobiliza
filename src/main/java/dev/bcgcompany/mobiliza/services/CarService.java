package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.CarListingResponseDTO;
import dev.bcgcompany.mobiliza.entities.Car;
import dev.bcgcompany.mobiliza.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<CarListingResponseDTO> listAllCars(Pageable pageable, Optional<LocalDate> startDate, Optional<LocalDate> endDate) {
        return startDate.isPresent() && endDate.isPresent()
                ? carRepository.findAvailableCars(startDate.get(), endDate.get(), pageable)
                        .map(CarListingResponseDTO::new)
                : carRepository.findByRentedFalse(pageable)
                        .map(CarListingResponseDTO::new);
    }
}