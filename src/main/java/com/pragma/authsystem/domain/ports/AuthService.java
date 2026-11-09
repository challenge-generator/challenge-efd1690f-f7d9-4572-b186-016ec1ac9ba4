package com.pragma.authsystem.domain.ports;

import com.pragma.authsystem.domain.model.User;
import java.util.Map;

public interface AuthService {
    String generateToken(User user);
    boolean validateToken(String token);
    Map<String, Object> authenticate(String email, String password);
    Map<String, Object> authenticateWithOAuth(String provider, String token);
}