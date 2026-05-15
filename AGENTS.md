# Java AI Lab Agents

## Modelo Rector
- Provider: MiniMax
- Model: MiniMax-M2.7
- API base: https://api.minimax.io/v1
- API mode: OpenAI-compatible chat completions

## Reglas de oro (NO NEGOCIABLES)
1. SDD antes de TDD — sin spec no hay código.
2. RED debe fallar por la razón esperada.
3. GREEN mínimo — solo lo necesario para pasar.
4. Sin evidencia = sin claim.
5. No manual code by the human.
6. Siempre inspeccionar antes de cambiar.
7. No build después de cambios.
8. Todo practice termina con: report + tests + diff + next step.
9. No declares éxito sin evidencia.

## Stack
- Java 25 LTS (preview features habilitadas)
- Spring Boot (BOM gestionado)
- Kafka + Kafka Streams (transacciones event-driven)
- Clean Architecture (domain/core/application/infrastructure)
- SOLID / DRY / KISS

## Comandos de validación

| Comando | Qué valida |
|---------|------------|
| `java -version` | Java 25 LTS |
| `./mvnw test` | Unit tests (Rojo si no hay código aún) |
| `./mvnw verify` | Integration + contract tests |
| `./mvnw compile --enable-preview` | Compilación con preview features |
| `sdd-verify` | Spec compliance (después de apply) |
| `git diff --stat` | Archivos cambiados |
| `find . -type d` | Estructura de directorios |

## Política anti-claims

| Claim | Requiere evidencia |
|-------|--------------------|
| "Funciona" | Test unitario passing + diff |
| "Es escalable" | Benchmark o profiling real |
| "Es seguro" | Test de seguridad ejecutándose |
| "Cumple spec" | sdd-verify verde |
| "No hay regresión" | `./mvnw test` passing |

**Sin evidencia = claim rechazado.**

## Gobernanza de cambio

Cada cambio atraviesa esta secuencia obligatoria:

```
PRD → RFC → SDD → design → proposal → tasks → apply → verify → archive
```

### Artefactos por fase

| Fase | Ubicación | Contenido |
|------|------------|-----------|
| PRD | PRD/*.md | Problema, goals, non-goals, risks |
| RFC | RFC/*.md | Arquitectura propuesta, open questions |
| SDD | SDD/*.md | Intent, scope, consequences |
| Design | design/*.md | Decisiones arquitectónicas con racional |
| Proposal | proposal/*.md | Motivación, approach, deliverables |
| Tasks | tasks/*.md | Checklist de implementación verificable |
| Evidence | docs/evidence/*/ | Screenshots, JSON, logs, diffs |
| Spec | docs/specs/*/ | Given/When/Then requirements |

## Estructura Clean Architecture

```
src/main/java/com/javail/
├── domain/              # Entidades, value objects, reglas de negocio puras
│   ├── model/
│   └── service/
├── application/        # Casos de uso, puertos (interfaces)
│   ├── port/
│   └── usecase/
├── infrastructure/      # Adaptadores: Kafka, DB, REST
│   ├── adapter/
│   ├── kafka/
│   └── persistence/
└── api/                 # Controllers, DTOs

src/test/java/com/javail/
├── unit/
├── integration/
└── contract/
```

**Principio:** `domain` no tiene dependencias. `application` depende solo de `domain`. `infrastructure` depende de `application` y `domain`.

## Roles
- **orchestrator**: scope, secuencia, gobernanza, MiniMax M2.7 policy.
- **java**: Spring Boot, arquitectura, tests.
- **web**: API, frontend, docs, runtime.
- **uix**: copy-paste, UX, accesibilidad.
- **pedagogy**: learning path, claridad, outcomes.
- **design**: iconos, diagramas, jerarquía visual.

## Riesgos y rollback

### Riesgos
| Riesgo | Probabilidad | Impacto | Mitigación |
|--------|--------------|---------|------------|
| Arquitectura contaminada | Alta | Alto | Clean Architecture verificado en sdd-verify |
| Claims sin evidencia | Alta | Alto | Policy hardcoded en AGENTS.md |
| Circular SDD loop | Media | Alto | Cada fase tiene exit criteria claro |

### Rollback
```bash
# Full rollback
git reset --hard HEAD~1

# Rollback de archivo específico
git checkout HEAD~1 -- src/archivo.java
```

## Git hooks (pre-commit)

Validaciones automáticas en cada commit:
- No commit sin mensaje遵循 conventional commits
- No commit si hay archivos sin evidencia asociada en docs/evidence/
- No commit si los tests no compilan