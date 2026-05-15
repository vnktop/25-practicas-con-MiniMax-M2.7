# SDD 01 — Platform Bootstrap

## Change
Bootstrap de plataforma Java AI Lab con estructura Clean Architecture y gobernanza SDD.

## Intent
Establecer la base arquitectónica sobre la cual se construirán prácticas futuras de inteligencia operacional event-driven.

## Scope
### In Scope
- Estructura de directorios Clean Architecture
- Archivos de gobernanza (PRD/RFC/SDD/design/proposal/tasks)
- AGENTS.md actualizado
- .git/ con hooks de validación

### Out of Scope
- Código funcional (domain logic)
- Runtime de Kafka
- Tests de integración

## Design
design/01-bootstrap-design.md

## Consequences
### Positive
- Workspace consistente para todos los agentes
- Gobernanza SDD visible y trazable
- Clean Architecture enforced desde el día uno

### Negative
- Overhead inicial de estructura para prácticas simples

## Evidence
docs/specs/01-platform-bootstrap/ — (vacío, se llena con specs de cada práctica)