package com.example.patterns.observer.EventBus.matchStrategy;

import com.example.patterns.observer.EventBus.EventType;

import java.util.LinkedList;
import java.util.List;

public class StrictMatchStrategy implements MatchStrategy {

    @Override
    public List<EventType> findMatchEventType(EventType eventType, Object event) {
        List<EventType> result = new LinkedList<>();
        result.add(eventType);
        return result;
    }
}
