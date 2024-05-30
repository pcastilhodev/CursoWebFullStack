package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.LoginRequest;
import com.example.demo.controller.dto.LoginResponse;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.TokenService;


@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest body) {
        // Buscar o usuário no repositório
        Usuario usuario = usuarioRepository.findUserByLogin(body.login())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Gerar token
        String token = tokenService.generateToken(usuario);
        LoginResponse response = new LoginResponse(token, tokenService.getExpirationTime());

        return ResponseEntity.ok(response);
    }
}