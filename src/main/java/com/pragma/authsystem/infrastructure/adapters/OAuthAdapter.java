package com.pragma.authsystem.infrastructure.adapters;

import com.pragma.authsystem.domain.model.User;
import com.pragma.authsystem.domain.ports.AuthService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class OAuthAdapter implements AuthService {

    private static final String GOOGLE_PROVIDER = "google";
    private static final String GITHUB_PROVIDER = "github";

    @Override
    public String generateToken(User user) {
        throw new UnsupportedOperationException("No implementado para OAuth");
    }

    @Override
    public boolean validateToken(String token) {
        throw new UnsupportedOperationException("No implementado para OAuth");
    }

    @Override
    public Map<String, Object> authenticate(String email, String password) {
        throw new UnsupportedOperationException("No implementado para OAuth");
    }

    @Override
    public Map<String, Object> authenticateWithOAuth(String provider, String token) {
        if (provider == null || token == null) {
            throw new IllegalArgumentException("Provider y token son requeridos");
        }

        User user = switch (provider.toLowerCase()) {
            case GOOGLE_PROVIDER -> authenticateWithGoogle(token);
            case GITHUB_PROVIDER -> authenticateWithGithub(token);
            default -> throw new IllegalArgumentException("Proveedor OAuth no soportado: " + provider);
        };

        String jwtToken = generateToken(user);
        
        return Map.of(
            "token", jwtToken,
            "userId", user.id().toString(),
            "email", user.email(),
            "provider", provider
        );
    }

    private User authenticateWithGoogle(String token) {
        // Stub: el estudiante implementará la validación del token de Google
        // Debo llamar al proveedor externo, verificar el token y obtener los datos del usuario
        return new User(
            UUID.randomUUID(),
            "oauth-user@gmail.com",
            "oauth_password_placeholder",
            "OAuth User"
        );
    }

    private User authenticateWithGithub(String token) {
        // Stub: el estudiante implementará la validación del token de GitHub
        return new User(
            UUID.randomUUID(),
            "oauth-user@github.com",
            "oauth_password_placeholder",
            "OAuth User"
        );
    }
}