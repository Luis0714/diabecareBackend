package com.example.demo.Api.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.Persistence.Entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtils {
    private final String secretKey = "diabecarekey";
    private final Algorithm ALGORITHM = Algorithm.HMAC256(secretKey);
    public String create(UserEntity userEntity){
        return JWT.create()
                .withSubject(userEntity.getEmail())
                .withClaim("name", userEntity.getFirstName())
                .withClaim("lastname", userEntity.getLastName())
                .withClaim("id", userEntity.getUserId())
                .withClaim("foto", userEntity.getPhoto())
                .withIssuer("diabecare")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(1)))
                .sign(ALGORITHM);

    }
}
