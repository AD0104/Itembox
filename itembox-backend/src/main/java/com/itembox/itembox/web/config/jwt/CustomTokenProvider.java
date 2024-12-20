package com.itembox.itembox.web.config.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class CustomTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    private Logger logger = LoggerFactory.getLogger(CustomTokenProvider.class);

    public String generateToken(Authentication authentication){
        String userName = authentication.getName();
        
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                        .subject(userName)
                        .issuedAt(new Date())
                        .expiration(expireDate)
                        .signWith(key())
                        .compact();
        return token;
    }

    public String getUsername(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parse(token);
        } catch(ExpiredJwtException jwtException) {
            logger.info("[CustomTokenProvider.validateToken] Exception Raised, Cause: {}", jwtException.getMessage());
            return false;
        }
        return true;
    }
    
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));   
    }
}
