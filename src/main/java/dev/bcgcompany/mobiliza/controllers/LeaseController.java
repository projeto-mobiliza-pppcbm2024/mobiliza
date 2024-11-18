package dev.bcgcompany.mobiliza.controllers;

import dev.bcgcompany.mobiliza.controllers.dto.LeaseRequestDTO;
import dev.bcgcompany.mobiliza.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    private final LeaseService leaseService;

    @Autowired
    public LeaseController(LeaseService leaseService) {
        this.leaseService = leaseService;
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmLease(
            @RequestBody LeaseRequestDTO leaseRequestDTO,
            JwtAuthenticationToken jwtAuthenticationToken) {
        String userId = jwtAuthenticationToken.getToken().getSubject();
        leaseService.confirm(userId, leaseRequestDTO);
        return ResponseEntity.ok().build();
    }
}
