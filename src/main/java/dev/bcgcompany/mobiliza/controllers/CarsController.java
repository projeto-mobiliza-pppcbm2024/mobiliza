package dev.bcgcompany.mobiliza.controllers;

import dev.bcgcompany.mobiliza.controllers.dto.CarListingResponseDTO;
import dev.bcgcompany.mobiliza.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Page<CarListingResponseDTO>> listCars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<CarListingResponseDTO> listedCars = carService.listAllCars(PageRequest.of(page, size));
        return ResponseEntity.ok(listedCars);
    }
}