package com.pragma.authsystem.application.usecases;

import com.pragma.authsystem.domain.model.User;
import com.pragma.authsystem.domain.ports.AuthService;
import com.pragma.authsystem.domain.ports.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class AuthUseCase implements AuthService {

    private final UserRepository userRepository;
    private final AuthService jwtAuthService;

    public AuthUseCase(UserRepository userRepository, AuthService jwtAuthService) {
        this.userRepository = userRepository;
        this.jwtAuthService = jwtAuthService;
    }

    @Override
    public String generateToken(User user) {
        return jwtAuthService.generateToken(user);
    }

    @Override
    public boolean validateToken(String token) {
        return jwtAuthService.validateToken(token);
    }

    @Override
    public Map<String, Object> authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        
        User user = userOpt.get();
        
        if (!password.equals(user.password())) {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
        
        String token = generateToken(user);
        
        return Map.of(
            "token", token,
            "userId", user.id().toString(),
            "email", user.email()
        );
    }

    @Override
    public Map<String, Object> authenticateWithOAuth(String provider, String token) {
        return jwtAuthService.authenticateWithOAuth(provider, token);
    }
}