package com.example.demo.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.model.Usuario;
import com.example.demo.model.acesso;

import jakarta.transaction.Transactional;

@Service
public class TokenService {

    @Value("${jwt.secret.key}")
    public String secret;
	
    @Transactional
    public String generateToken(Usuario user) {
        try {
            String acessos = user.getAcessos()
                    .stream()
                    .map(acesso::getDescricao)
                    .collect(Collectors.joining(" "));

            Algorithm algoritmo = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("altis")
                    .withSubject(user.getLogin())
                    .withExpiresAt(this.expiresin())
                    .withClaim("SCOPE", acessos)  
                    .sign(algoritmo);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("erro ao autenticar");
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("altis")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    public Instant expiresin(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public long getExpirationTime() {
        return 2 * 60 * 60;
    }
}