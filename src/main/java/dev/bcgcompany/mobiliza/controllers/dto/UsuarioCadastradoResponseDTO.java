package dev.bcgcompany.mobiliza.controllers.dto;

public record UsuarioCadastradoResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    String phone,
    String cnh,
    String token,
    Long tokenExpirationTime
) { }