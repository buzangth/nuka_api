package com.genetics.nuka_api.security;

import com.genetics.nuka_api.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.genetics.nuka_api.security.SecurityConstant.EXPIRATION_TIME;
import static com.genetics.nuka_api.security.SecurityConstant.SECRET;

@Component
public class JWTTokenProvider {
  
    public String generateToken(Authentication authentication){

        User user =(User)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String,Object> claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("firstname", user.getFirstname());
        claims.put("surname", user.getSurname());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}