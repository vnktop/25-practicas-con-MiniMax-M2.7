package com.javail.unit;

import com.javail.domain.model.OperationalEvent;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperationalEventTest {

    @Test
    void testCreateOperationalEvent_withValidData() {
        // Given: valid event data
        String id = "evt-001";
        long timestamp = System.currentTimeMillis();
        String type = "DEVICE_CONNECTED";
        String payload = "{\"deviceId\":\"dev-123\",\"status\":\"online\"}";

        // When: creating operational event
        var event = new OperationalEvent(id, timestamp, type, payload);

        // Then: event fields are correctly set
        assertEquals(id, event.id());
        assertEquals(timestamp, event.timestamp());
        assertEquals(type, event.type());
        assertEquals(payload, event.payload());
    }

    @Test
    void testCreateOperationalEvent_withNullId_throwsException() {
        // Given: null id
        long timestamp = System.currentTimeMillis();
        String type = "DEVICE_CONNECTED";
        String payload = "{}";

        // When/Then: creating event with null id throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new OperationalEvent(null, timestamp, type, payload);
        });
    }

    @Test
    void testCreateOperationalEvent_withBlankId_throwsException() {
        // Given: blank id
        long timestamp = System.currentTimeMillis();
        String type = "DEVICE_CONNECTED";
        String payload = "{}";

        // When/Then: creating event with blank id throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new OperationalEvent("   ", timestamp, type, payload);
        });
    }

    @Test
    void testCreateOperationalEvent_withNullType_throwsException() {
        // Given: null type
        String id = "evt-001";
        long timestamp = System.currentTimeMillis();
        String payload = "{}";

        // When/Then: creating event with null type throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new OperationalEvent(id, timestamp, null, payload);
        });
    }

    @Test
    void testCreateOperationalEvent_withBlankType_throwsException() {
        // Given: blank type
        String id = "evt-001";
        long timestamp = System.currentTimeMillis();
        String payload = "{}";

        // When/Then: creating event with blank type throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new OperationalEvent(id, timestamp, "", payload);
        });
    }
}