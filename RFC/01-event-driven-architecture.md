# RFC 01 — Event-Driven Architecture for Operational Intelligence

## Status
Draft

## Problem Statement
La plataforma requiere procesar eventos de inteligencia operacional de forma reactiva, tolerante a fallos, y escalable horizontalmente.

## Proposed Solution
- Kafka como mensaje backbone
- Kafka Streams para procesamiento stateful
- Clean Architecture para separación de concerns
- Domain events como unidad de comunicación

## Architecture Overview
```
Producer → Kafka → Kafka Streams → Consumer
                ↓
           Domain Events
                ↓
        Clean Architecture Layers
```

## Open Questions
- ¿Schema registry para Avro/Protobuf?
- ¿Dead letter queue strategy?
- ¿Monitoreo: Prometheus + Grafana o OpenTelemetry?

## Evidence
docs/evidence/01-event-driven-architecture/ — (vacío)