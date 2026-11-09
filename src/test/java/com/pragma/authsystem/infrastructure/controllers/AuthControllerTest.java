package com.pragma.authsystem.infrastructure.controllers;

import com.pragma.authsystem.domain.ports.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @Test
    void testLoginExitoso() throws Exception {
        String tokenMock = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIn0.test";
        when(authService.authenticate(anyString(), anyString()))
                .thenReturn(Map.of(
                        "token", tokenMock,
                        "user", Map.of("email", "test@example.com", "id", UUID.randomUUID().toString())
                ));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "email": "test@example.com",
                                "password": "password123"
                            }
                            """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void testLoginCredencialesInvalidas() throws Exception {
        when(authService.authenticate(anyString(), anyString()))
                .thenThrow(new RuntimeException("Credenciales inválidas"));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "email": "wrong@example.com",
                                "password": "wrongpassword"
                            }
                            """))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testLoginEmailVacio() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "email": "",
                                "password": "password123"
                            }
                            """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testLoginPasswordVacio() throws Exception {
        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "email": "test@example.com",
                                "password": ""
                            }
                            """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testOAuthLoginExitoso() throws Exception {
        String tokenMock = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnb29nbGUtdXNlciJ9.test";
        when(authService.authenticateWithOAuth(anyString(), anyString()))
                .thenReturn(Map.of(
                        "token", tokenMock,
                        "user", Map.of("email", "google-user@example.com", "id", UUID.randomUUID().toString())
                ));

        mockMvc.perform(post("/api/auth/oauth/google")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "provider": "google",
                                "token": "google-oauth-token"
                            }
                            """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void testOAuthProviderInvalido() throws Exception {
        when(authService.authenticateWithOAuth(anyString(), anyString()))
                .thenThrow(new RuntimeException("Proveedor OAuth no soportado"));

        mockMvc.perform(post("/api/auth/oauth/invalid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                                "provider": "invalid",
                                "token": "some-token"
                            }
                            """))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "test@example.com")
    void testAccesoARecursoProtegido() throws Exception {
        mockMvc.perform(get("/api/users/me"))
                .andExpect(status().isOk());
    }

    @Test
    void testAccesoSinAutenticacion() throws Exception {
        mockMvc.perform(get("/api/users/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testTokenExpirado() throws Exception {
        mockMvc.perform(get("/api/users/me")
                        .header("Authorization", "Bearer expired.token.here"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testTokenFormatoInvalido() throws Exception {
        mockMvc.perform(get("/api/users/me")
                        .header("Authorization", "InvalidFormat"))
                .andExpect(status().isUnauthorized());
    }
}