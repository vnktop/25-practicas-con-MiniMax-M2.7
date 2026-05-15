# Design 01 — Bootstrap Design

## Status
Draft

## Architectural Decisions

### AD-01: Clean Architecture Layers
**Decision:** domain → application → infrastructure (sin dependencias inversas)
**Rationale:** Aislamiento de lógica de negocio, testeabilidad
**Evidence:** src/main/java/com/javail/*/

### AD-02: Package by Feature (no by layer)
**Decision:** Cada bounded context tiene su propio paquete con domain/application/infrastructure
**Rationale:** Cohesión, evitar acoplamiento cruzado
**Evidence:** practices/01/src/main/java/com/javail/...

### AD-03: Java 25 LTS Preview Features
**Decision:** Enable preview features (string templates, implicitly declared classes)
**Rationale:** Adoptarearly features de Java LTS
**Evidence:** pom.xml con `<enable-preview>true</enable-preview>`

## Component Diagram
```
AGENTS.md (orchestrator rules)
    ↓
PRD → RFC → SDD → design → proposal → tasks
    ↓           ↓
docs/specs  docs/evidence
```

## Validation
```bash
./mvnw test   # 0 tests = rojo esperado
find . -type d | grep -E "(domain|application|infrastructure)"  # Verifica estructura
```