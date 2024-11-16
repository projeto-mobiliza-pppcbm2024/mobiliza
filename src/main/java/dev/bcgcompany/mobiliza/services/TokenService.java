package dev.bcgcompany.mobiliza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import dev.bcgcompany.mobiliza.entities.Users;
import org.springframework.stereotype.Service;

import static java.time.Instant.now;

@Service
public class TokenService {

    private static final String ISSUER = "mobiliza";
    public static final Long TOKEN_EXPIRATION_TIME = 300L;
    
    private final JwtEncoder jwtEncoder;

    @Autowired
    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String getUserToken(Users user) {
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
