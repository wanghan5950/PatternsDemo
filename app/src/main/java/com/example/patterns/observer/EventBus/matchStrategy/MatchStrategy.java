package com.example.patterns.observer.EventBus.matchStrategy;

import com.example.patterns.observer.EventBus.EventType;
import java.util.List;

/**
 * 事件匹配策略
 */
public interface MatchStrategy {

    /**
     * 获取匹配的事件类型列表
     * @param eventType
     * @param event
     * @return
     */
    List<EventType> findMatchEventType(EventType eventType, Object event);
}
