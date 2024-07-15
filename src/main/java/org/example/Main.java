package org.example;


public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();

        // Simulate login
        String token = authService.login("user", "pass");
        System.out.println("JWT Token: " + token);

        // Simulate request with token
        boolean isAuthenticated = authService.authenticate(token);
        System.out.println("Is authenticated: " + isAuthenticated);
    }
}
