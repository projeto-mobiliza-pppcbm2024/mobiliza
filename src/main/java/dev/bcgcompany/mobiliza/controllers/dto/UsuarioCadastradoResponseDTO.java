package dev.bcgcompany.mobiliza.controllers.dto;

public record UsuarioCadastradoResponseDTO(
    Long id,
    String nome,
    String email
) { }