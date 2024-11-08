package dev.bcgcompany.mobiliza.controllers.dto;

public record LoginResponseDTO (
        String token,
        Long tokenExpirationTime
) {}