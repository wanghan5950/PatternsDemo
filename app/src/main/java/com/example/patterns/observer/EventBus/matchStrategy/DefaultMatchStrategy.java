package com.example.patterns.observer.EventBus.matchStrategy;

import com.example.patterns.observer.EventBus.EventType;

import java.util.LinkedList;
import java.util.List;

public class DefaultMatchStrategy implements MatchStrategy {

    @Override
    public List<EventType> findMatchEventType(EventType eventType, Object event) {
        Class<?> eventClass = event.getClass();
        List<EventType> result = new LinkedList<>();
        while (eventClass != null) {
            result.add(new EventType(eventClass, eventType.tag));
            addInterfaces(result, eventClass, eventType.tag);
            eventClass =eventClass.getSuperclass();
        }
        return result;
    }

    /**
     * 获取该事件的所有接口类型
     * @param eventTypes 事件类型列表
     * @param eventClass 事件的类
     * @param tag 标识符
     */
    private void addInterfaces(List<EventType> eventTypes, Class<?> eventClass, String tag) {
        if (eventClass == null) {
            return;
        }
        Class<?>[] interfaceClasses = eventClass.getInterfaces();
        for (Class<?> interfaceClass : interfaceClasses) {
            if (!eventTypes.contains(interfaceClass)) {
                eventTypes.add(new EventType(interfaceClass, tag));
                addInterfaces(eventTypes, interfaceClass, tag);
            }
        }
    }
}
