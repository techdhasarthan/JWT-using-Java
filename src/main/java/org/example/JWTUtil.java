package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JWTUtil {
    private static final String SECRET = "mySecretKey"; // Use a strong secret key
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);

    public static String createToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .sign(algorithm);
    }

    public static String validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject();
        } catch (JWTVerificationException exception) {

            // Invalid token
            return null;
        }
    }
}

