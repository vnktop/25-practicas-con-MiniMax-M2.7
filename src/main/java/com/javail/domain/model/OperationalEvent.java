package com.javail.domain.model;

/**
 * Operational event domain entity.
 * Immutable record representing an event in the operational intelligence platform.
 *
 * @param id        Unique event identifier (required, non-blank)
 * @param timestamp Event occurrence time in milliseconds
 * @param type      Event type classification (required, non-blank)
 * @param payload   JSON-encoded event data (optional, may be null or empty)
 */
public record OperationalEvent(
        String id,
        long timestamp,
        String type,
        String payload
) {

    public OperationalEvent {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or blank");
        }
    }
}