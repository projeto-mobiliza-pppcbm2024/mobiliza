package dev.bcgcompany.mobiliza.controllers;

import dev.bcgcompany.mobiliza.dtos.LeaseRequestDTO;
import dev.bcgcompany.mobiliza.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmLease(
            @RequestBody LeaseRequestDTO leaseRequestDTO,
            Principal principal
    ) {
        String userId = principal.getName();
        leaseService.processLease(Long.parseLong(userId), leaseRequestDTO);
        return ResponseEntity.ok("Lease confirmed successfully!");
    }
}
