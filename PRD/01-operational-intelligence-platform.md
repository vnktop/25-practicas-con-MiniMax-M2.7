# PRD 01 — Operational Intelligence Event-Driven Platform

## Status
Draft

## Context
Java AI Lab necesita una plataforma de Inteligencia Operacional gobernada por SDD/TDD, event-driven, lista para Kafka Streams y Clean Architecture.

## Goals
- [ ] Plataforma bootstrap con estructura Clean Architecture verificable
- [ ] Stack Java 25 LTS + Spring Boot + Kafka
- [ ] Gobernanza SDD completa: PRD → RFC → SDD → design → proposal → tasks
- [ ] Evidencias documentadas en docs/evidence/
- [ ] Tests unitarios mínimo, sin código funcional aún

## Non-Goals
- No runtime funcional en esta práctica
- No conexión real a Kafka
- No despliegue

## Risks
- Stack mal configurado → mitificar: pom.xml mínimo verificable
- Arquitectura contaminada → mitigar: Clean Architecture verificado en sdd-verify

## Evidence
docs/evidence/01-platform-bootstrap/ — (vacío, se llena al validar)