package dev.bcgcompany.mobiliza.controllers;

import dev.bcgcompany.mobiliza.controllers.dto.*;
import dev.bcgcompany.mobiliza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UsuarioCadastradoResponseDTO> registerUser(@RequestBody CadastroUsuarioRequestDTO cadastroUsuarioRequestDTO) {
        UsuarioCadastradoResponseDTO responseDTO = userService.registerUser(cadastroUsuarioRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}