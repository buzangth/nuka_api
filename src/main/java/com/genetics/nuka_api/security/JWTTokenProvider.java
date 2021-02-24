package com.genetics.nuka_api.security;

import com.genetics.nuka_api.model.User;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.genetics.nuka_api.security.SecurityConstant.EXPIRATION_TIME;
import static com.genetics.nuka_api.security.SecurityConstant.SECRET;

@Component
public class JWTTokenProvider {

//    generating  jwt token
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
        claims.put("branch",user.getBranch());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
// validating token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token);
            return true;
        } catch (SignatureException ex) {

            System.out.println("invalid JWT Signature");

        } catch (MalformedJwtException ex) {
            System.out.println("invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("EXPIRED JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("not support JWT token");
        }
        return false;
    }

    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJwt(token).getBody();

        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }


}