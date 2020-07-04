package com.example.patterns.observer.EventBus.handler;

import com.example.patterns.observer.EventBus.Subscription;

/**
 * 事件处理接口
 */
public interface EventHandler {

    /**
     * 处理事件
     * @param subscription 观察者对象
     * @param event 事件对象
     */
    void handEvent(Subscription subscription, Object event);
}
