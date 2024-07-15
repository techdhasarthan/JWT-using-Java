package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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