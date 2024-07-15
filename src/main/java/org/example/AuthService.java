package org.example;

public class AuthService {
    public String login(String username, String password) {

        // Validate the username and password against your data store
        if (isValidUser(username, password)) {
            return JWTUtil.createToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public boolean authenticate(String token) {
        String username = JWTUtil.validateToken(token);
        return username != null;
    }

    private boolean isValidUser(String username, String password) {

        // Check the username and password against your data store
        return "user".equals(username) && "pass".equals(password);
    }
}
