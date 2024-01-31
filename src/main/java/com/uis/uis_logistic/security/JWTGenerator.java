package com.uis.uis_logistic.security;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
import java.security.Key;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.access.event.AuthenticationCredentialsNotFoundEvent;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JWTGenerator {

    public String generateToken(Authentication authentication) throws Exception {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

        String token;

        try {
            token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(expireDate)
                    .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET.getBytes("UTF-8"))
                    .compact();
        } catch (JwtException e) {
            // Handle the exception, e.g., log it, wrap it in a custom exception, etc.
            throw new Exception("Error while generating JWT");
        }

        System.out.println("New token :");
        System.out.println(token);
        return token;
    }
    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was exprired or incorrect");
        }
    }
}
