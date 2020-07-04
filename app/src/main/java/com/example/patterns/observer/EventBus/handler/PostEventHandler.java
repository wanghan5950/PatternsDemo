package com.example.patterns.observer.EventBus.handler;

import com.example.patterns.observer.EventBus.Subscription;
import java.lang.reflect.InvocationTargetException;

/**
 * 在发布事件的线程执行事件
 */
public class PostEventHandler implements EventHandler {

    @Override
    public void handEvent(Subscription subscription, Object event) {
        if (subscription == null || subscription.subscriber.get() == null) {
            return;
        }
        try {
            subscription.targetMethod.invoke(subscription.subscriber.get(), event);
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
