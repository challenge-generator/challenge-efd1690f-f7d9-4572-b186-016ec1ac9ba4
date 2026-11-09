package com.pragma.authsystem.infrastructure.controllers;

import com.pragma.authsystem.domain.ports.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        Map<String, Object> response = authService.authenticate(email, password);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/oauth/{provider}")
    public ResponseEntity<Map<String, Object>> oauthLogin(
            @PathVariable String provider,
            @RequestBody Map<String, String> tokenData) {
        String token = tokenData.get("token");
        
        Map<String, Object> response = authService.authenticateWithOAuth(provider, token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Object>> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        boolean isValid = authService.validateToken(token);
        
        Map<String, Object> response = new HashMap<>();
        response.put("valid", isValid);
        
        return ResponseEntity.ok(response);
    }
}