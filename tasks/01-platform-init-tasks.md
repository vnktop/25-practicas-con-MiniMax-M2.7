# Tasks 01 — Platform Bootstrap Tasks

## Change
SDD-01: Platform Bootstrap

## Task List

- [ ] **T-01: Crear estructura de directorios**
  - Clean Architecture: domain/, application/, infrastructure/
  - Governance: PRD/, RFC/, SDD/, design/, proposal/, tasks/
  - Tests: unit/, integration/, contract/
  - **Verify:** `find . -type d | sort`

- [ ] **T-02: Poblar archivos de gobernanza SDD**
  - PRD/01-operational-intelligence-platform.md
  - RFC/01-event-driven-architecture.md
  - SDD/01-platform-bootstrap.md
  - design/01-bootstrap-design.md
  - proposal/01-platform-init-proposal.md
  - **Verify:** `ls PRD/ RFC/ SDD/ design/ proposal/ tasks/`

- [ ] **T-03: Actualizar AGENTS.md**
  - Agregar comandos de validación
  - Agregar política anti-claims
  - **Verify:** `grep -E "(validate|evidence|claim)" AGENTS.md`

- [ ] **T-04: Commit inicial**
  - `git add -A && git commit -m "feat: bootstrap platform structure"`
  - **Verify:** `git log --oneline -1`

- [ ] **T-05: Verificar estructura final**
  - `find . -type d | grep -E "(domain|application|infrastructure)" | wc -l` → 7+
  - `find . -type f -name "*.md" | wc -l` → 6+
  - **Verify:** `./mvnw test` → BUILD SUCCESS, 0 tests

## Rollback
```bash
git reset --hard HEAD~1
```

## Evidence Required
- Diff del commit (`git diff --stat HEAD~1`)
- Output de `find` verifying estructura
- Output de `./mvnw test` (0 tests = rojo esperado)