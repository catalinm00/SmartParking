package com.smartparking.smartparking.infrastructure.messaging;

import com.smartparking.smartparking.domain.Event;

public interface Publisher<E extends Event> {
    void publish(E event);
}
