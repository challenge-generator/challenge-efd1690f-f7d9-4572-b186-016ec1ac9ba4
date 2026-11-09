# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de Mecanismos de Autenticación y Utilización de JWT**.

| | |
|---|---|
| Tema | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con capas de dominio, aplicación e infraestructura |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-security n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- io.jsonwebtoken:jjwt-api 0.12.3
- io.jsonwebtoken:jjwt-impl 0.12.3
- io.jsonwebtoken:jjwt-jackson 0.12.3
- org.springframework.boot:spring-boot-starter-oauth2-client n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.springframework.security:spring-security-test n/a
- org.postgresql:postgresql n/a
- org.projectlombok:lombok n/a
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración Inicial y Autenticación Básica**: Endpoint funcional para autenticación básica con credenciales que devuelve un token JWT.
- **Fase 2 — Implementación de Segundo Mecanismo de Autenticación**: Endpoint funcional para un segundo mecanismo de autenticación que también devuelve un token JWT.
- **Fase 3 — Protección de Recursos y Manejo de Errores**: Recursos protegidos con middleware que verifica tokens JWT y maneja adecuadamente los errores de autenticación.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/pragma/authsystem/domain/model/User.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/domain/ports/UserRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/domain/ports/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/application/usecases/AuthUseCase.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/adapters/UserJpaRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/adapters/OAuthAdapter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/controllers/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/pragma/authsystem/infrastructure/security/GlobalExceptionHandler.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/authsystem/infrastructure/controllers/AuthControllerTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtilTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que falta y tenes que completar

No se detectaron huecos: estan los archivos declarados, el boilerplate del stack y ninguna referencia quedo colgando. Igual corre el comando de verificacion — que los archivos existan no garantiza que compilen.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/pragma/authsystem/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/authsystem/domain/model/User.java`
- `src/main/java/com/pragma/authsystem/domain/ports/UserRepository.java`
- `src/main/java/com/pragma/authsystem/domain/ports/AuthService.java`
- `src/main/java/com/pragma/authsystem/infrastructure/adapters/UserJpaRepository.java`
- `src/main/java/com/pragma/authsystem/application/usecases/AuthUseCase.java`
- `src/main/java/com/pragma/authsystem/infrastructure/adapters/OAuthAdapter.java`
- `src/main/java/com/pragma/authsystem/infrastructure/controllers/AuthController.java`
- `src/main/java/com/pragma/authsystem/infrastructure/security/SecurityConfig.java`
- `src/main/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtil.java`
- `src/main/java/com/pragma/authsystem/infrastructure/security/JwtAuthenticationFilter.java`
- `src/main/java/com/pragma/authsystem/infrastructure/security/GlobalExceptionHandler.java`
- `src/test/java/com/pragma/authsystem/infrastructure/controllers/AuthControllerTest.java`
- `src/test/java/com/pragma/authsystem/infrastructure/security/JwtTokenUtilTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/authsystem`
- `src/main/java/com/pragma/authsystem/domain`
- `src/main/java/com/pragma/authsystem/domain/model`
- `src/main/java/com/pragma/authsystem/domain/ports`
- `src/main/java/com/pragma/authsystem/application`
- `src/main/java/com/pragma/authsystem/application/usecases`
- `src/main/java/com/pragma/authsystem/infrastructure`
- `src/main/java/com/pragma/authsystem/infrastructure/adapters`
- `src/main/java/com/pragma/authsystem/infrastructure/config`
- `src/main/java/com/pragma/authsystem/infrastructure/controllers`
- `src/main/java/com/pragma/authsystem/infrastructure/security`
- `src/main/resources`
- `src/test/java/com/pragma/authsystem`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con capas de dominio, aplicación e infraestructura**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT, Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
