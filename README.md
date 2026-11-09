# Implementación de Mecanismos de Autenticación y Utilización de JWT

El candidato debe implementar dos mecanismos de autenticación y demostrar su habilidad para identificar y utilizar JWTs en un sistema de backend. El sistema debe permitir la autenticación de usuarios a través de credenciales y tokens JWT. Los usuarios registrados pueden acceder a recursos protegidos luego de autenticarse correctamente. El sistema debe manejar adecuadamente los errores de autenticación y proporcionar mensajes claros al usuario.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración Inicial y Autenticación Básica

**Objetivo:** Configurar el entorno de desarrollo y crear un endpoint para autenticación básica con credenciales.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar el entorno de desarrollo con las dependencias necesarias.
- Crear un endpoint que acepte credenciales de usuario y verifique su autenticidad.
- Generar un token JWT al autenticarse correctamente.

**Entregable:** Endpoint funcional para autenticación básica con credenciales que devuelve un token JWT.

<details>
<summary>Pistas de conocimiento</summary>

- Conceptos de autenticación y autorización.
- Uso de tokens JWT para sesiones seguras.

</details>

### Fase 2: Implementación de Segundo Mecanismo de Autenticación

**Objetivo:** Implementar un segundo mecanismo de autenticación, como la autenticación con OAuth.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Investigar y seleccionar un segundo mecanismo de autenticación (ej. OAuth).
- Implementar el endpoint necesario para este mecanismo.
- Asegurar que el sistema pueda manejar ambos tipos de autenticación.

**Entregable:** Endpoint funcional para un segundo mecanismo de autenticación que también devuelve un token JWT.

<details>
<summary>Pistas de conocimiento</summary>

- Diferencias entre los mecanismos de autenticación.
- Integración de servicios externos para autenticación.

</details>

### Fase 3: Protección de Recursos y Manejo de Errores

**Objetivo:** Proteger recursos del sistema y manejar adecuadamente los errores de autenticación.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identificar recursos que requieren protección.
- Implementar middleware para verificar tokens JWT en solicitudes protegidas.
- Manejar errores de autenticación y proporcionar mensajes claros al usuario.

**Entregable:** Recursos protegidos con middleware que verifica tokens JWT y maneja adecuadamente los errores de autenticación.

<details>
<summary>Pistas de conocimiento</summary>

- Uso de middleware en el framework seleccionado.
- Estrategias para manejar errores de autenticación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un token JWT y cómo se utiliza en la autenticación?
- **paraQueSirve**: ¿Para qué sirve implementar múltiples mecanismos de autenticación en un sistema?
- **comoSeUsa**: ¿Cómo se utiliza un middleware para proteger recursos en el framework seleccionado?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar mecanismos de autenticación y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección de un mecanismo de autenticación sobre otro?

## Criterios de Evaluacion

- Implementación correcta de un endpoint para autenticación básica con credenciales.
- Implementación correcta de un segundo mecanismo de autenticación.
- Protección adecuada de recursos con middleware que verifica tokens JWT.
- Manejo adecuado de errores de autenticación con mensajes claros al usuario.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
