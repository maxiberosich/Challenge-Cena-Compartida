package com.maxicb.cenas_compartidas.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.maxicb.cenas_compartidas.exception.ValidacionDeIntegridad;
import com.maxicb.cenas_compartidas.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("cenas-compartidas")
                    .withSubject(usuario.getNombreUsuario())
                    .withClaim("id", usuario.getIdUsuario())
                    .withExpiresAt( generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new ValidacionDeIntegridad("Error al generar Token");
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-06:00"));
    }

    public String getSubject(String token){
        if (token == null){
            throw new ValidacionDeIntegridad("Token no puede ser nulo");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("cenas-compartidas")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw new ValidacionDeIntegridad("Token inválido");
        }
    }

}