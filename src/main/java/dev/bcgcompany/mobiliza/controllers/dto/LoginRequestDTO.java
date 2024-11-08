package dev.bcgcompany.mobiliza.controllers.dto;

public record LoginRequestDTO(
        String email,
        String password
) {}