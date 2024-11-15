package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.LoginRequestDTO;
import dev.bcgcompany.mobiliza.controllers.dto.LoginResponseDTO;
import dev.bcgcompany.mobiliza.entities.Users;
import dev.bcgcompany.mobiliza.exceptions.UnauthorizedUserException;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static dev.bcgcompany.mobiliza.services.TokenService.TOKEN_EXPIRATION_TIME;

@Service
public class LoginService {

    private final UsersRepository usersRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.usersRepository = usersRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Users user = usersRepository.findByEmail(loginRequestDTO.email())
                .filter(users -> isValidLogin(users, loginRequestDTO.password()))
                .orElseThrow(UnauthorizedUserException::new);
        String token = tokenService.getUserToken(user);
        return new LoginResponseDTO(token, TOKEN_EXPIRATION_TIME);
    }

    private boolean isValidLogin(Users user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }
}