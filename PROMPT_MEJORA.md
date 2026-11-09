# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/authsystem/domain/model/User.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/domain/ports/UserRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/domain/ports/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/application/usecases/AuthUseCase.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/adapters/UserJpaRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/adapters/OAuthAdapter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/controllers/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/authsystem/infrastructure/security/GlobalExceptionHandler.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/authsystem/infrastructure/controllers/AuthControllerTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtilTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT, Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

### Reto
- Tema: Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de Mecanismos de Autenticación y Utilización de JWT
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración Inicial y Autenticación Básica — objetivo: Configurar el entorno de desarrollo y crear un endpoint para autenticación básica con credenciales. — entregable (NO resolver): Endpoint funcional para autenticación básica con credenciales que devuelve un token JWT.
- Fase 2: Implementación de Segundo Mecanismo de Autenticación — objetivo: Implementar un segundo mecanismo de autenticación, como la autenticación con OAuth. — entregable (NO resolver): Endpoint funcional para un segundo mecanismo de autenticación que también devuelve un token JWT.
- Fase 3: Protección de Recursos y Manejo de Errores — objetivo: Proteger recursos del sistema y manejar adecuadamente los errores de autenticación. — entregable (NO resolver): Recursos protegidos con middleware que verifica tokens JWT y maneja adecuadamente los errores de autenticación.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>authsystem</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>authsystem</name>
    <description>Sistema de autenticación con JWT y OAuth2</description>

    <properties>
        <java.version>21</java.version>
        <springdoc-openapi-ui.version>2.5.0</springdoc-openapi-ui.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-client</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.12.3</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.12.3</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.12.3</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- SpringDoc OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi-ui.version}</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/authsystem/Application.java ===
package com.pragma.authsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase principal de la aplicación Spring Boot.
 * Configura CORS global para permitir solicitudes desde cualquier origen durante el desarrollo.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always

spring:
  application:
    name: authsystem
  datasource:
    url: jdbc:postgresql://localhost:5432/authdb
    username: authuser
    password: authpass
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: ${GOOGLE_CLIENT_ID}
            client-secret: ${GOOGLE_CLIENT_SECRET}
            scope: openid,profile,email
            redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
            client-name: Google
          github:
            client-id: ${GITHUB_CLIENT_ID}
            client-secret: ${GITHUB_CLIENT_SECRET}
            scope: read:user,user:email
            redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
            client-name: GitHub

jwt:
  secret: ${JWT_SECRET:defaultSecretKeyForDevelopmentOnlyChangeInProduction}
  expiration: 86400000 # 24 horas en milisegundos
  issuer: authsystem

logging:
  level:
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    com.pragma.authsystem: DEBUG

// === ARCHIVO: src/main/java/com/pragma/authsystem/domain/model/User.java ===
package com.pragma.authsystem.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

public record User(
    UUID id,

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede exceder los 50 caracteres")
    String name,

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    String email,

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password,

    String role,

    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    boolean active
) {
    public User {
        if (id == null) {
            id = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        if (role == null) {
            role = "USER";
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/domain/ports/UserRepository.java ===
package com.pragma.authsystem.domain.ports;

import com.pragma.authsystem.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    void deleteById(UUID id);
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/domain/ports/AuthService.java ===
package com.pragma.authsystem.domain.ports;

import com.pragma.authsystem.domain.model.User;
import java.util.Map;

public interface AuthService {
    String generateToken(User user);
    boolean validateToken(String token);
    Map<String, Object> authenticate(String email, String password);
    Map<String, Object> authenticateWithOAuth(String provider, String token);
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/adapters/UserJpaRepository.java ===
package com.pragma.authsystem.infrastructure.adapters;

import com.pragma.authsystem.domain.model.User;
import com.pragma.authsystem.domain.ports.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserJpaRepository implements UserRepository {

    private final JpaRepository<User, UUID> jpaRepository;

    public UserJpaRepository(JpaRepository<User, UUID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/application/usecases/AuthUseCase.java ===
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

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/adapters/OAuthAdapter.java ===
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

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/controllers/AuthController.java ===
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

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/security/SecurityConfig.java ===
package com.pragma.authsystem.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtil.java ===
package com.pragma.authsystem.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret:mySecretKeyForJwtTokenGenerationThatIsLongEnough}")
    private String secret;

    @Value("${jwt.expiration:86400000}")
    private Long expiration;

    private SecretKey getSigningKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username, Map<String, Object> claims) {
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
            .claims(claims)
            .subject(subject)
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(getSigningKey())
            .compact();
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public Boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/security/JwtAuthenticationFilter.java ===
package com.pragma.authsystem.infrastructure.security;

import com.pragma.authsystem.domain.ports.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthService authService;

    public JwtAuthenticationFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // STUB: La implementación de validación de JWT se completará en las fases del reto
        // Este es el andamiaje que permite al candidato practicar la implementación
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/api/auth/") || path.equals("/swagger-ui.html") || path.startsWith("/swagger-ui/");
    }
}

// === ARCHIVO: src/main/java/com/pragma/authsystem/infrastructure/security/GlobalExceptionHandler.java ===
package com.pragma.authsystem.infrastructure.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Validation failed");
        response.put("details", errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid credentials");
        error.put("message", "Email or password is incorrect");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Authentication failed");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal server error");
        error.put("message", "An unexpected error occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

// === ARCHIVO: src/test/java/com/pragma/authsystem/infrastructure/controllers/AuthControllerTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtilTest.java ===
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
```
