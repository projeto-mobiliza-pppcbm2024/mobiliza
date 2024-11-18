package dev.bcgcompany.mobiliza.controllers.dto;

import dev.bcgcompany.mobiliza.entities.Car;
import dev.bcgcompany.mobiliza.entities.Lease;
import dev.bcgcompany.mobiliza.entities.Users;

import java.time.LocalDate;

public record LeaseRequestDTO(
        Long carId,
        LocalDate startDate,
        LocalDate finalDate,
        PaymentDetailsDTO paymentDetails
) {

    public Lease toLease(Users user, Car car) {
        return Lease.builder()
                .user(user)
                .car(car)
                .initialDate(startDate)
                .finalDate(finalDate)
                .build();
    }
}