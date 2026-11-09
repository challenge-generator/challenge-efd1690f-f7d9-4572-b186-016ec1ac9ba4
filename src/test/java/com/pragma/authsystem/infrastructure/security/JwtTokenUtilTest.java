package com.pragma.authsystem.infrastructure.security;

import com.pragma.authsystem.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenUtilTest {

    private JwtTokenUtil jwtTokenUtil;
    private User testUser;
    private static final String SECRET = "testSecretKeyForJwtTokenGenerationThatIsLongEnoughForHS256Algorithm";

    @BeforeEach
    void setUp() {
        jwtTokenUtil = new JwtTokenUtil();
        ReflectionTestUtils.setField(jwtTokenUtil, "secret", SECRET);
        ReflectionTestUtils.setField(jwtTokenUtil, "expiration", 86400000L);

        testUser = new User(
                UUID.randomUUID(),
                "test@example.com",
                "password123",
                "Test User",
                "USER"
        );
    }

    @Test
    void testGenerarTokenExitoso() {
        String token = jwtTokenUtil.generateToken(testUser);

        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.contains("."));
    }

    @Test
    void testGenerarTokenContieneSubject() {
        String token = jwtTokenUtil.generateToken(testUser);

        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(testUser.email(), claims.getSubject());
    }

    @Test
    void testGenerarTokenContieneEmailClaim() {
        String token = jwtTokenUtil.generateToken(testUser);

        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(testUser.email(), claims.get("email"));
    }

    @Test
    void testGenerarTokenContieneRolClaim() {
        String token = jwtTokenUtil.generateToken(testUser);

        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertEquals(testUser.role(), claims.get("role"));
    }

    @Test
    void testExtractUsername() {
        String token = jwtTokenUtil.generateToken(testUser);
        String username = jwtTokenUtil.extractUsername(token);

        assertEquals(testUser.email(), username);
    }

    @Test
    void testExtractUsernameTokenInvalido() {
        String invalidToken = "invalid.token.here";
        String username = jwtTokenUtil.extractUsername(invalidToken);

        assertNull(username);
    }

    @Test
    void testValidateTokenTokenValido() {
        String token = jwtTokenUtil.generateToken(testUser);
        boolean isValid = jwtTokenUtil.validateToken(token, testUser);

        assertTrue(isValid);
    }

    @Test
    void testValidateTokenTokenOtroUsuario() {
        String token = jwtTokenUtil.generateToken(testUser);
        User otroUsuario = new User(
                UUID.randomUUID(),
                "otro@example.com",
                "password",
                "Otro Usuario",
                "USER"
        );

        boolean isValid = jwtTokenUtil.validateToken(token, otroUsuario);

        assertFalse(isValid);
    }

    @Test
    void testValidateTokenTokenExpirado() {
        String expiredToken = createExpiredToken();
        boolean isValid = jwtTokenUtil.validateToken(expiredToken, testUser);

        assertFalse(isValid);
    }

    @Test
    void testValidateTokenTokenFirmadoConOtraClave() {
        String tokenWithDifferentKey = createTokenWithDifferentSecret();
        boolean isValid = jwtTokenUtil.validateToken(tokenWithDifferentKey, testUser);

        assertFalse(isValid);
    }

    @Test
    void testExtractClaim() {
        String token = jwtTokenUtil.generateToken(testUser);
        String email = jwtTokenUtil.extractClaim(token, claims -> claims.get("email", String.class));

        assertEquals(testUser.email(), email);
    }

    @Test
    void testExtractExpiration() {
        String token = jwtTokenUtil.generateToken(testUser);
        Date expiration = jwtTokenUtil.extractExpiration(token);

        assertNotNull(expiration);
        assertTrue(expiration.after(new Date()));
    }

    @Test
    void testIsTokenExpiredFalse() {
        String token = jwtTokenUtil.generateToken(testUser);
        boolean isExpired = jwtTokenUtil.isTokenExpired(token);

        assertFalse(isExpired);
    }

    @Test
    void testIsTokenExpiredTrue() {
        String expiredToken = createExpiredToken();
        boolean isExpired = jwtTokenUtil.isTokenExpired(expiredToken);

        assertTrue(isExpired);
    }

    @Test
    void testExtractAllClaims() {
        String token = jwtTokenUtil.generateToken(testUser);
        Claims claims = jwtTokenUtil.extractAllClaims(token);

        assertNotNull(claims);
        assertEquals(testUser.email(), claims.getSubject());
        assertEquals(testUser.email(), claims.get("email"));
        assertEquals(testUser.role(), claims.get("role"));
    }

    private String createExpiredToken() {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .subject(testUser.email())
                .claim("email", testUser.email())
                .claim("role", testUser.role())
                .expiration(new Date(System.currentTimeMillis() - 1000))
                .issuedAt(new Date(System.currentTimeMillis() - 2000))
                .signWith(key)
                .compact();
    }

    private String createTokenWithDifferentSecret() {
        String differentSecret = "differentSecretKeyForJwtTokenThatIsLongEnoughForHS256";
        SecretKey key = Keys.hmacShaKeyFor(differentSecret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .subject(testUser.email())
                .claim("email", testUser.email())
                .claim("role", testUser.role())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }
}