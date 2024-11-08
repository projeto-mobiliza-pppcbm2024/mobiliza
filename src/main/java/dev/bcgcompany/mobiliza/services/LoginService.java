package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.LoginRequestDTO;
import dev.bcgcompany.mobiliza.controllers.dto.LoginResponseDTO;
import dev.bcgcompany.mobiliza.entities.Users;
import dev.bcgcompany.mobiliza.exceptions.UnauthorizedUserException;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import static java.time.Instant.now;

@Service
public class LoginService {

    private static final String ISSUER = "mobiliza";
    private static final Long TOKEN_EXPIRATION_TIME = 300L;

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    @Autowired
    public LoginService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, JwtEncoder jwtEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Users user = usersRepository.findByEmail(loginRequestDTO.email())
                .filter(users -> isValidLogin(users, loginRequestDTO.password()))
                .orElseThrow(UnauthorizedUserException::new);
        String token = getUserToken(user);
        return new LoginResponseDTO(token, TOKEN_EXPIRATION_TIME);
    }

    private boolean isValidLogin(Users user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    private String getUserToken(Users user) {
        JwtClaimsSet claims = defineUserTokenClaims(user);
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private JwtClaimsSet defineUserTokenClaims(Users user) {
        String userId = user.getId().toString();
        String scope = user.getRole().name();
        return JwtClaimsSet.builder()
                .issuer(ISSUER)
                .subject(userId)
                .issuedAt(now())
                .expiresAt(now().plusSeconds(TOKEN_EXPIRATION_TIME))
                .claim("scope", scope)
                .build();
    }
}