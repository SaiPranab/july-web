package com.tastytown.backend.security.jwt;

import com.tastytown.backend.constants.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

@Component
@Slf4j
public class JWTUtils {
    @Value("${JWT.SECRET}")
    private String JWT_SECRET;

    private static final Duration TOKEN_EXPIRATION = Duration.ofHours(24);

    private SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(JWT_SECRET);
        SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);
        return  secretKey;
    }

    public String generateToken(/** claims */String userId, Role role) {
        Instant currentTime = Instant.now();
        Instant expirationTime = currentTime.plus(TOKEN_EXPIRATION);

        String token = Jwts.builder()
                .subject(userId)
                .claim("role", role)
                .issuedAt(Date.from(currentTime))
                .expiration(Date.from(expirationTime))
                .signWith(getKey())
                .compact();

        log.info("JWT token generated", token);
        return token;
    }

    public String extractUsername(String token) {
        String username = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        log.info("Extract Username: ", username);
        return username;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = userDetails.getUsername();
        boolean isValidToken = username.equals(extractUsername(token)) && !isTokenExpired(token);

        return isValidToken;
    }

    private boolean isTokenExpired(String token) {
        Instant expirationTime = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration()
                .toInstant();

        boolean isExpired = expirationTime.isBefore(Instant.now());
        return isExpired;
    }
}
