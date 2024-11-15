package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.CadastroUsuarioRequestDTO;
import dev.bcgcompany.mobiliza.controllers.dto.UsuarioCadastradoResponseDTO;
import dev.bcgcompany.mobiliza.entities.Users;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static dev.bcgcompany.mobiliza.entities.Role.BASIC;
import static dev.bcgcompany.mobiliza.services.TokenService.TOKEN_EXPIRATION_TIME;

@Service
public class UserService {

    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Autowired
    public UserService(UsersRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public UsuarioCadastradoResponseDTO registerUser(CadastroUsuarioRequestDTO cadastroUsuarioRequestDTO) {

        // Verifica se o email já está cadastrado
        if (userRepository.findByEmail(cadastroUsuarioRequestDTO.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado"); 
        }

        // Criptografar a senha
        String senhaCriptografada = passwordEncoder.encode(cadastroUsuarioRequestDTO.password());

        Users user = new Users();
        user.setName(cadastroUsuarioRequestDTO.name());
        user.setEmail(cadastroUsuarioRequestDTO.email());
        user.setPassword(senhaCriptografada);
        user.setCpf(cadastroUsuarioRequestDTO.cpf());
        user.setCnh(cadastroUsuarioRequestDTO.cnh());
        user.setPhone(cadastroUsuarioRequestDTO.phone());
        user.setRole(BASIC);

        userRepository.save(user);
        String token = tokenService.getUserToken(user);

        return new UsuarioCadastradoResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getPhone(),
                user.getCnh(),
                token,
                TOKEN_EXPIRATION_TIME
        );
    }
}