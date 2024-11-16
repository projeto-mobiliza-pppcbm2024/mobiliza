package dev.bcgcompany.mobiliza.controllers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.bcgcompany.mobiliza.entities.Car;

import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

public record CarListingResponseDTO(

        Long id,
        String name,
        String desription,

        @JsonFormat(shape = STRING, pattern = "#,##0.00")
        BigDecimal pricePerDay
) {

        public CarListingResponseDTO(Car car) {
                this(car.getId(), car.getName(), car.getDescription(), car.getPrice());
        }
}