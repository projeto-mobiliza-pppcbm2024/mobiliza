package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.CadastroUsuarioRequestDTO;
import dev.bcgcompany.mobiliza.controllers.dto.UsuarioCadastradoResponseDTO;
import dev.bcgcompany.mobiliza.entities.Role;
import dev.bcgcompany.mobiliza.entities.Users;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static dev.bcgcompany.mobiliza.entities.Role.BASIC;

@Service
public class UserService {

    private UsersRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        Users usuarioSalvo = userRepository.save(user);

        return new UsuarioCadastradoResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getName(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getCpf(),
                usuarioSalvo.getPhone(),
                usuarioSalvo.getCnh()
        );
    }
}