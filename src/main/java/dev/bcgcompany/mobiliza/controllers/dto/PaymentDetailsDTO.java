package dev.bcgcompany.mobiliza.controllers.dto;

import dev.bcgcompany.mobiliza.entities.Payment;
import dev.bcgcompany.mobiliza.entities.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentDetailsDTO(
        Integer installmentNumber,
        BigDecimal installmentAmount,
        LocalDate paymentDate,
        PaymentMethod paymentMethod
) {
    public Payment toPayment() {
        return Payment.builder()
                .installments(installmentNumber)
                .instalmentAmount(installmentAmount)
                .paymentDate(paymentDate)
                .paymentMethod(paymentMethod)
                .build();
    }
}