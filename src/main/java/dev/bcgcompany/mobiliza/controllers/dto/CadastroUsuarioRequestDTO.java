package dev.bcgcompany.mobiliza.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioRequestDTO(

    @NotBlank(message = "O nome é obrigatório")
    String name,

    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    String email,

    @NotBlank(message = "O CPF é obrigatório")
    String cpf,

    @NotBlank(message = "O telefone é obrigatório")
    String phone,

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 8, message = "A senha deve ter no mínimo 6 caracteres")
    String password,

    @NotBlank(message = "A CNH é obrigatório")
    String cnh

) {}