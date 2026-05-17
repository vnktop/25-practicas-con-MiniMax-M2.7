# Health API Spec

## Context

Operational Intelligence platform needs basic health/info endpoints for load balancer probes and service discovery.

## Endpoints

### GET /health

**Given** a client sends GET /health
**When** the service is running
**Then** returns 200 OK with body `{"status":"UP"}`

### GET /info

**Given** a client sends GET /info
**When** the service is running
**Then** returns 200 OK with:
- `artifact`: "java-ai-lab"
- `version`: "0.1.0-SNAPSHOT"

## Acceptance Criteria

- [ ] /health returns HTTP 200
- [ ] /health body contains `"status":"UP"`
- [ ] /info returns HTTP 200
- [ ] /info body contains artifact and version fields
- [ ] Tests pass under `./mvnw test`

## Implementation

| File | Role |
|------|------|
| `HealthController.java` | REST endpoints |
| `HealthControllerTest.java` | @WebMvcTest slice test |

## Evidence

See `docs/evidence/` for test output logs.